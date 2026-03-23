package com.blueair.api;

import android.content.res.Resources;
import com.blueair.api.client.AblCloudClient;
import com.blueair.api.client.BlueCloudClient;
import com.blueair.api.client.BluetoothDeviceClient;
import com.blueair.api.client.CanProvisionLocal;
import com.blueair.api.client.DeviceClient;
import com.blueair.api.client.WifiDeviceClient;
import com.blueair.api.model.ConnectionCapability;
import com.blueair.api.model.UsesAblCloud;
import com.blueair.api.model.UsesBlueCloud;
import com.blueair.api.model.UsesBluetooth;
import com.blueair.api.model.UsesWifi;
import com.blueair.auth.AuthService;
import com.blueair.core.model.Device;
import io.flatcircle.ble.BleService;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import io.flatcircle.coroutinehelper.PurposeFullyLeftEmptyException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import okhttp3.Interceptor;
import timber.log.Timber;

@Metadata(d1 = {"\u0000î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0013\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tJ\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002J@\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010 \"\n\b\u0001\u0010!\u0018\u0001*\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u001f0#HH¢\u0006\u0002\u0010$J.\u0010%\u001a\u00020\u0019\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u000f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u00020\u00190#HH¢\u0006\u0002\u0010$JT\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010&\"\u0004\b\u0001\u0010 \"\n\b\u0002\u0010!\u0018\u0001*\u00020\u000f2\u001e\u0010\"\u001a\u001a\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u001f0'2\u0006\u0010(\u001a\u0002H&HH¢\u0006\u0002\u0010)J@\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H 0\u001f\"\u0004\b\u0000\u0010 \"\n\b\u0001\u0010!\u0018\u0001*\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u001f0*HH¢\u0006\u0002\u0010+JB\u0010%\u001a\u00020\u0019\"\u0004\b\u0000\u0010&\"\n\b\u0001\u0010!\u0018\u0001*\u00020\u000f2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u0002H!\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u00020\u00190'2\u0006\u0010(\u001a\u0002H&HH¢\u0006\u0002\u0010)J\u0010\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.J \u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015000\u001fH@¢\u0006\u0002\u00101J\u000e\u00102\u001a\u00020\u00192\u0006\u00103\u001a\u00020\u0015J\u0014\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001fH@¢\u0006\u0002\u00101J\u001a\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u000208070\u001fH@¢\u0006\u0002\u00101J,\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:070\u001f2\u0006\u0010;\u001a\u00020\u00112\b\u0010<\u001a\u0004\u0018\u00010=H@¢\u0006\u0002\u0010>J<\u0010?\u001a\b\u0012\u0004\u0012\u00020@0\u001f2\u0006\u0010A\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00152\u0006\u0010E\u001a\u00020\u0015H@¢\u0006\u0002\u0010FJ\u001e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f2\b\u0010H\u001a\u0004\u0018\u000105H@¢\u0006\u0002\u0010IJ\u0014\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fH@¢\u0006\u0002\u00101J\u0014\u0010K\u001a\b\u0012\u0004\u0012\u00020L0\u001fH@¢\u0006\u0002\u00101J\"\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L070\u001f2\u0006\u0010N\u001a\u00020OH@¢\u0006\u0002\u0010PJ\u001a\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020R070\u001fH@¢\u0006\u0002\u00101J\u0014\u0010S\u001a\b\u0012\u0004\u0012\u00020T0\u001fH@¢\u0006\u0002\u00101J\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010W\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010Y\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010Z\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u0014\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00010\u001fH@¢\u0006\u0002\u00101J\u001c\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0006\u0010]\u001a\u00020\u0001H@¢\u0006\u0002\u0010^J\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010`\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010a\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010b\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010c\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010d\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001a\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0015070\u001fH@¢\u0006\u0002\u00101J\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010h\u001a\u00020\u0015H@¢\u0006\u0002\u0010iJ\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010k\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010l\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010m\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010o\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010q\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010s\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010t\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010u\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010w\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u0014\u0010{\u001a\b\u0012\u0004\u0012\u00020V0\u001fH@¢\u0006\u0002\u00101J\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001c\u0010\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ(\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0011H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ1\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0011H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ'\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020TH@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010y\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010y\u001a\u00030\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ+\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u0001\u001a\u00020\u00112\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H@¢\u0006\u0003\u0010\u0001J+\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010\u0001\u001a\u00020\u00112\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H@¢\u0006\u0003\u0010\u0001J\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001d\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u0015\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001fH@¢\u0006\u0002\u00101J\u001d\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001d\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001d\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u001d\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ+\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010«\u0001\u001a\u00020\u00112\n\u0010¬\u0001\u001a\u0005\u0018\u00010­\u0001H@¢\u0006\u0003\u0010®\u0001J(\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010°\u0001\u001a\u00020\u00112\u0007\u0010±\u0001\u001a\u00020\u0011H@¢\u0006\u0003\u0010\u0001J\u0015\u0010²\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001fH@¢\u0006\u0002\u00101J)\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u00112\t\b\u0002\u0010´\u0001\u001a\u00020TH@¢\u0006\u0003\u0010\u0001J\u001d\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020TH@¢\u0006\u0002\u0010eJ\u001e\u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010·\u0001\u001a\u00020\u0015H@¢\u0006\u0002\u0010iJ!\u0010¸\u0001\u001a\t\u0012\u0005\u0012\u00030¹\u00010\u001f2\b\u0010º\u0001\u001a\u00030»\u0001H@¢\u0006\u0003\u0010¼\u0001J\"\u0010½\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001f2\b\u0010º\u0001\u001a\u00030»\u0001H@¢\u0006\u0003\u0010¼\u0001J\u001c\u0010¾\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030»\u0001070\u001fH@¢\u0006\u0002\u00101J\u0018\u0010¿\u0001\u001a\u00020\u00192\u0007\u0010À\u0001\u001a\u00020\u0015H@¢\u0006\u0002\u0010iJ\u001d\u0010Á\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0006\u0010y\u001a\u00020\u0011H@¢\u0006\u0002\u0010XJ\u0007\u0010Â\u0001\u001a\u00020\u0019J\u001e\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00010\u001f2\u0007\u0010Ä\u0001\u001a\u00020\u0015H@¢\u0006\u0002\u0010iJ\u001e\u0010Å\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u001f2\u0007\u0010Æ\u0001\u001a\u00020\u0015H@¢\u0006\u0002\u0010iJ\u0015\u0010Ç\u0001\u001a\b\u0012\u0004\u0012\u00020\u00150\u001fH@¢\u0006\u0002\u00101J \u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u001f2\b\u0010É\u0001\u001a\u00030Ê\u0001H@¢\u0006\u0003\u0010Ë\u0001J\u0015\u0010Ì\u0001\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH@¢\u0006\u0002\u00101R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006Í\u0001"}, d2 = {"Lcom/blueair/api/ConnectionManager;", "", "resources", "Landroid/content/res/Resources;", "bleService", "Lio/flatcircle/ble/BleService;", "authService", "Lcom/blueair/auth/AuthService;", "device", "Lcom/blueair/core/model/Device;", "<init>", "(Landroid/content/res/Resources;Lio/flatcircle/ble/BleService;Lcom/blueair/auth/AuthService;Lcom/blueair/core/model/Device;)V", "clientLock", "clients", "", "Lcom/blueair/api/client/DeviceClient;", "clientsSize", "", "getClientsSize", "()I", "uid", "", "getUid", "()Ljava/lang/String;", "updateDevice", "", "nuDevice", "generateNewClients", "addDeviceIpToClient", "client", "doApiCall", "Lio/flatcircle/coroutinehelper/ApiResult;", "Output", "CanCall", "call", "Lkotlin/reflect/KSuspendFunction1;", "(Lkotlin/reflect/KFunction;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doApiCallUnit", "Input", "Lkotlin/reflect/KSuspendFunction2;", "input", "(Lkotlin/reflect/KFunction;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logApiError", "error", "", "getRand", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "assignJwtToClients", "deviceJwt", "getNewUuid", "Lcom/blueair/core/model/DeviceUuid;", "getSsids", "", "Lcom/blueair/core/model/Ssid;", "getOnboardingEvents", "Lcom/blueair/core/model/DeviceEvent;", "iteration", "mockedError", "Lcom/blueair/core/model/OnboardingError;", "(ILcom/blueair/core/model/OnboardingError;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "provisionDevice", "Lcom/blueair/api/model/ProvisionRequestBody;", "ssid", "bssid", "password", "rand", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetDevice", "deviceUuid", "(Lcom/blueair/core/model/DeviceUuid;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "switchOffSoftAp", "getLatestSensorData", "Lcom/blueair/core/model/IndoorDatapoint;", "getMonthSensorData", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttributes", "Lcom/blueair/api/restapi/DeviceAttributeOnAbl;", "getIsUpdating", "", "setFanSpeed", "Lcom/blueair/api/restapi/SimpleResponse;", "nuFanspeed", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "resetAutoModeDependency", "setAutoModeDependency", "nuValue", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBrightness", "nuBrightness", "setChildLock", "nuChildLock", "setDisinfection", "nuDisinfection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLinkedUid", "setLinkedUid", "nuUid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setStandBy", "nuStandBy", "setEcoMode", "newValue", "setHinsMode", "hinsMode", "setHinsNightMode", "hinsNightMode", "setG4NightMode", "nuG4NightMode", "setGermShieldMode", "nuGermShieldMode", "setGermShieldNightMode", "nuGermShieldNightMode", "setWickDryEnabled", "value", "setWickDryOn", "cancelWickDryMode", "setWickdryDurationAndOn", "setAutoRh", "setTimerStatus", "setTimerDuration", "setTimerDurationAndStatus", "duration", "status", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTemperatureUnit", "setOscillationState", "setOscillationParams", "angle", "direction", "fanSpeed", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainMode", "setApSubMode", "overwriteMainMode", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolAutoPresets", "tag", "presets", "", "(I[DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoolEcoPresets", "setMode", "setHumMode", "setDehSubMode", "setSmartSubMode", "setTare", "setPanelDisplayMode", "setHoverEnabled", "setAirRefreshStatus", "setAirRefreshEnabled", "setNightLampBrightness", "setNightLampSteplessBrightness", "setYwrmEnabled", "setAlarm", "index", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "(ILcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playAlarm", "sound", "volume", "stopAlarm", "setHumSubMode", "cancelWickDry", "setUse24Hour", "deleteLinkedUid", "linkedUid", "createSchedule", "Lokhttp3/ResponseBody;", "deviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSchedule", "getSchedules", "deleteSchedule", "scheduleId", "setSensorMode", "clear", "setDeviceName", "name", "setFilterType", "nuFilter", "getDeviceStatus", "createWelcomeHome", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "(Lcom/blueair/core/model/WelcomeHomeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWelcomeHome", "api_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ConnectionManager.kt */
public final class ConnectionManager {
    private final AuthService authService;
    private final BleService bleService;
    private final Object clientLock = new Object();
    private final List<DeviceClient> clients = new ArrayList();
    private Device device;

    public ConnectionManager(Resources resources, BleService bleService2, AuthService authService2, Device device2) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(bleService2, "bleService");
        Intrinsics.checkNotNullParameter(authService2, "authService");
        Intrinsics.checkNotNullParameter(device2, "device");
        this.bleService = bleService2;
        this.authService = authService2;
        this.device = device2;
        generateNewClients(resources);
    }

    public final int getClientsSize() {
        return this.clients.size();
    }

    public final String getUid() {
        return this.device.getUid();
    }

    public final void updateDevice(Device device2) {
        Intrinsics.checkNotNullParameter(device2, "nuDevice");
        if (this.device.getUid().length() != 0 && !Intrinsics.areEqual((Object) this.device.getUid(), (Object) device2.getUid())) {
            throw new IllegalArgumentException("You can't change the device. Instantiate a new ConnectionManager instead.".toString());
        }
        this.device = device2;
        for (DeviceClient deviceUuid : this.clients) {
            deviceUuid.setDeviceUuid(this.device.getUid());
        }
    }

    private final void generateNewClients(Resources resources) {
        ConnectionCapability from = ConnectionCapability.Companion.from(this.device);
        synchronized (this.clientLock) {
            for (DeviceClient clear : this.clients) {
                clear.clear();
            }
            this.clients.clear();
            if (from instanceof UsesBluetooth) {
                this.clients.add(new BluetoothDeviceClient(this.bleService, resources, this.authService, this.device.getUid(), (String) null, (Interceptor) null, 48, (DefaultConstructorMarker) null));
            }
            if (from instanceof UsesWifi) {
                this.clients.add(new WifiDeviceClient(resources, this.device.getUid(), (String) null, this.authService, (Interceptor) null, 20, (DefaultConstructorMarker) null));
            }
            if (from instanceof UsesBlueCloud) {
                this.clients.add(new BlueCloudClient(resources, this.authService, this.device.getUid(), (Interceptor) null, 8, (DefaultConstructorMarker) null));
            }
            if (from instanceof UsesAblCloud) {
                this.clients.add(new AblCloudClient(resources, this.authService, this.device.getUid(), (Interceptor) null, 8, (DefaultConstructorMarker) null));
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r7 = r7.getIpv4();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void addDeviceIpToClient(com.blueair.api.client.DeviceClient r6, com.blueair.core.model.Device r7) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.blueair.api.client.WifiDeviceClient
            if (r0 == 0) goto L_0x004f
            boolean r0 = r7 instanceof com.blueair.core.model.HasBlueProvisionCalls
            if (r0 == 0) goto L_0x004f
            com.blueair.core.model.HasBlueProvisionCalls r7 = (com.blueair.core.model.HasBlueProvisionCalls) r7
            com.blueair.core.model.DeviceUuid r7 = r7.getDeviceUuid()
            r0 = 0
            if (r7 == 0) goto L_0x001c
            com.blueair.core.model.Ipv4 r7 = r7.getIpv4()
            if (r7 == 0) goto L_0x001c
            java.lang.String r7 = r7.getIp()
            goto L_0x001d
        L_0x001c:
            r7 = r0
        L_0x001d:
            if (r7 == 0) goto L_0x004f
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x004f
            java.lang.String r2 = "localhost"
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 2
            boolean r0 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r1, (java.lang.CharSequence) r2, (boolean) r3, (int) r4, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x004f
            java.lang.String r0 = "0.0.0.0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x004f
            com.blueair.api.client.WifiDeviceClient r6 = (com.blueair.api.client.WifiDeviceClient) r6
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "https://"
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r6.setBaseUrl(r7)
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.addDeviceIpToClient(com.blueair.api.client.DeviceClient, com.blueair.core.model.Device):void");
    }

    private final /* synthetic */ <Output, CanCall extends DeviceClient> Object doApiCall(KFunction<? extends ApiResult<Output>> kFunction, Continuation<? super ApiResult<Output>> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Attempting to doApiCall " + kFunction + " on " + this.clients.size() + " clients", new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        StringBuilder sb = new StringBuilder("Client info: ");
        sb.append(this.clients);
        forest2.v(sb.toString(), new Object[0]);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new Failure(new UnknownError("None of the clients in " + this + " could call " + kFunction));
        Collection arrayList = new ArrayList();
        for (Object next : this.clients) {
            Intrinsics.reifiedOperationMarker(3, "CanCall");
            if (next instanceof Object) {
                arrayList.add(next);
            }
        }
        for (DeviceClient deviceClient : (List) arrayList) {
            objectRef.element = ((Function2) kFunction).invoke(deviceClient, null);
            if (((ApiResult) objectRef.element).isSuccess()) {
                Timber.Forest forest3 = Timber.Forest;
                forest3.v("client " + deviceClient + " gave good result " + objectRef.element + " for call " + kFunction, new Object[0]);
                return objectRef.element;
            }
            Timber.Forest forest4 = Timber.Forest;
            forest4.w("client " + deviceClient + " gave failed result\n" + objectRef.element + " for call \n" + kFunction + ", \nwith details:", new Object[0]);
            Unit unit = Unit.INSTANCE;
        }
        logApiError(((ApiResult) objectRef.element).exceptionOrNull());
        return objectRef.element;
    }

    private final /* synthetic */ <CanCall extends DeviceClient> Object doApiCallUnit(KFunction<Unit> kFunction, Continuation<? super Unit> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Attempting to doApiCall " + kFunction + " on " + this.clients.size() + " clients", new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        StringBuilder sb = new StringBuilder("Client info: ");
        sb.append(this.clients);
        forest2.v(sb.toString(), new Object[0]);
        Collection arrayList = new ArrayList();
        for (Object next : this.clients) {
            Intrinsics.reifiedOperationMarker(3, "CanCall");
            if (next instanceof Object) {
                arrayList.add(next);
            }
        }
        for (DeviceClient invoke : (List) arrayList) {
            ((Function2) kFunction).invoke(invoke, null);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private final /* synthetic */ <Input, Output, CanCall extends DeviceClient> Object doApiCall(KFunction<? extends ApiResult<Output>> kFunction, Input input, Continuation<? super ApiResult<Output>> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Attempting to doApiCall " + kFunction + ", with " + input + " on " + this.clients.size() + " clients", new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        StringBuilder sb = new StringBuilder("Client info: ");
        sb.append(this.clients);
        forest2.v(sb.toString(), new Object[0]);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new Failure(new UnknownError("None of the clients in " + this + " could call " + kFunction));
        Collection arrayList = new ArrayList();
        for (Object next : this.clients) {
            Intrinsics.reifiedOperationMarker(3, "CanCall");
            if (next instanceof Object) {
                arrayList.add(next);
            }
        }
        for (DeviceClient deviceClient : (List) arrayList) {
            objectRef.element = ((Function3) kFunction).invoke(deviceClient, input, null);
            if (((ApiResult) objectRef.element).isSuccess()) {
                Timber.Forest forest3 = Timber.Forest;
                forest3.v("client " + deviceClient + " gave good result " + objectRef.element + " for call " + kFunction, new Object[0]);
                return objectRef.element;
            }
            Timber.Forest forest4 = Timber.Forest;
            forest4.w("client " + deviceClient + " gave failed result\n" + objectRef.element + " for call \n" + kFunction + ", \nwith details:", new Object[0]);
            Unit unit = Unit.INSTANCE;
        }
        logApiError(((ApiResult) objectRef.element).exceptionOrNull());
        return objectRef.element;
    }

    private final /* synthetic */ <Output, CanCall extends DeviceClient> Object doApiCall(Function1<? super CanCall, ? extends ApiResult<Output>> function1, Continuation<? super ApiResult<Output>> continuation) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        StringBuilder sb = new StringBuilder("None of the clients in ");
        sb.append(this);
        sb.append(" is ");
        Intrinsics.reifiedOperationMarker(4, "CanCall");
        sb.append(Reflection.getOrCreateKotlinClass(DeviceClient.class).getQualifiedName());
        objectRef.element = new Failure(new UnknownError(sb.toString()));
        Collection arrayList = new ArrayList();
        for (Object next : this.clients) {
            Intrinsics.reifiedOperationMarker(3, "CanCall");
            if (next instanceof Object) {
                arrayList.add(next);
            }
        }
        for (DeviceClient deviceClient : (List) arrayList) {
            objectRef.element = function1.invoke(deviceClient);
            if (((ApiResult) objectRef.element).isSuccess()) {
                Timber.Forest forest = Timber.Forest;
                forest.v("client " + deviceClient + " gave good result " + objectRef.element + " for call", new Object[0]);
                return objectRef.element;
            }
            Timber.Forest forest2 = Timber.Forest;
            forest2.w("client " + deviceClient + " gave failed result\n" + objectRef.element + " for call, \nwith details:", new Object[0]);
            Unit unit = Unit.INSTANCE;
        }
        logApiError(((ApiResult) objectRef.element).exceptionOrNull());
        return objectRef.element;
    }

    private final /* synthetic */ <Input, CanCall extends DeviceClient> Object doApiCallUnit(KFunction<Unit> kFunction, Input input, Continuation<? super Unit> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("Attempting to doApiCall " + kFunction + " on " + this.clients.size() + " clients", new Object[0]);
        Timber.Forest forest2 = Timber.Forest;
        StringBuilder sb = new StringBuilder("Client info: ");
        sb.append(this.clients);
        forest2.v(sb.toString(), new Object[0]);
        Collection arrayList = new ArrayList();
        for (Object next : this.clients) {
            Intrinsics.reifiedOperationMarker(3, "CanCall");
            if (next instanceof Object) {
                arrayList.add(next);
            }
        }
        for (DeviceClient invoke : (List) arrayList) {
            ((Function3) kFunction).invoke(invoke, input, null);
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void logApiError(Throwable th) {
        if (th != null) {
            if (th instanceof PurposeFullyLeftEmptyException) {
                Timber.Forest.v(th);
            } else if (th instanceof NotImplementedError) {
                Timber.Forest.w(th);
            } else {
                Timber.Forest.e(th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getRand(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<kotlin.Pair<java.lang.String, java.lang.String>>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getRand$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getRand$1 r0 = (com.blueair.api.ConnectionManager$getRand$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getRand$1 r0 = new com.blueair.api.ConnectionManager$getRand$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getRand$result$1 r15 = com.blueair.api.ConnectionManager$getRand$result$1.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanProvisionCloud
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            goto L_0x019f
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
        L_0x019f:
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Object r0 = r15.getOrNull()
            com.blueair.api.client.RandomVerifyText r0 = (com.blueair.api.client.RandomVerifyText) r0
            if (r0 != 0) goto L_0x01b1
            io.flatcircle.coroutinehelper.ApiResult$Companion r0 = io.flatcircle.coroutinehelper.ApiResult.Companion
            r1 = 0
            io.flatcircle.coroutinehelper.ApiResult r15 = r0.fromResult(r15, r1)
            return r15
        L_0x01b1:
            io.flatcircle.coroutinehelper.ApiResult$Companion r1 = io.flatcircle.coroutinehelper.ApiResult.Companion
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.String r3 = r0.getRand()
            java.lang.String r0 = r0.getText()
            r2.<init>(r3, r0)
            io.flatcircle.coroutinehelper.ApiResult r15 = r1.fromResult(r15, r2)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getRand(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void assignJwtToClients(String str) {
        Intrinsics.checkNotNullParameter(str, "deviceJwt");
        Collection arrayList = new ArrayList();
        for (Object next : this.clients) {
            if (next instanceof CanProvisionLocal) {
                arrayList.add(next);
            }
        }
        for (CanProvisionLocal canProvisionLocal : (List) arrayList) {
            canProvisionLocal.setDeviceJwt(str);
            Timber.Forest forest = Timber.Forest;
            forest.d("saved JWT for " + canProvisionLocal + " was added. Token = " + canProvisionLocal.getDeviceJwt(), new Object[0]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getNewUuid(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.DeviceUuid>> r53) {
        /*
            r52 = this;
            r0 = r52
            r1 = r53
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$getNewUuid$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$getNewUuid$1 r2 = (com.blueair.api.ConnectionManager$getNewUuid$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$getNewUuid$1 r2 = new com.blueair.api.ConnectionManager$getNewUuid$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x005c
            if (r4 != r5) goto L_0x0054
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$7
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$6
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$5
            java.lang.Object r10 = r2.L$4
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$3
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$1
            kotlin.reflect.KFunction r13 = (kotlin.reflect.KFunction) r13
            java.lang.Object r14 = r2.L$0
            com.blueair.api.ConnectionManager r14 = (com.blueair.api.ConnectionManager) r14
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0133
        L_0x0054:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$getNewUuid$uuid$1 r1 = com.blueair.api.ConnectionManager$getNewUuid$uuid$1.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r7, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r4.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00da:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ec
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanProvisionLocal
            if (r10 == 0) goto L_0x00da
            r8.add(r9)
            goto L_0x00da
        L_0x00ec:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r14 = r0
            r13 = r1
            r10 = r7
            r11 = r8
            r8 = r4
            r4 = r6
            r7 = r4
        L_0x00fb:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x0196
            java.lang.Object r1 = r10.next()
            r9 = r1
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            r12 = r13
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r2.L$0 = r14
            r2.L$1 = r13
            r2.L$2 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$3 = r15
            r2.L$4 = r10
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$5 = r1
            r2.L$6 = r9
            r2.L$7 = r8
            r2.I$0 = r7
            r2.I$1 = r4
            r2.I$2 = r6
            r2.label = r5
            java.lang.Object r1 = r12.invoke(r9, r2)
            if (r1 != r3) goto L_0x0132
            return r3
        L_0x0132:
            r12 = r8
        L_0x0133:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x0169
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            goto L_0x01a3
        L_0x0169:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r8)
            r15.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r15.append(r8)
            T r8 = r12.element
            r15.append(r8)
            java.lang.String r8 = " for call \n"
            r15.append(r8)
            r15.append(r13)
            java.lang.String r8 = ", \nwith details:"
            r15.append(r8)
            java.lang.String r8 = r15.toString()
            java.lang.Object[] r9 = new java.lang.Object[r6]
            r1.w(r8, r9)
            r8 = r12
            goto L_0x00fb
        L_0x0196:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r14.logApiError(r1)
            T r1 = r8.element
        L_0x01a3:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Object r2 = r1.getOrNull()
            com.blueair.core.model.DeviceUuid r2 = (com.blueair.core.model.DeviceUuid) r2
            if (r2 == 0) goto L_0x020d
            com.blueair.core.model.DeviceG4 r3 = new com.blueair.core.model.DeviceG4
            java.lang.String r4 = r2.getUuid()
            r50 = 3711(0xe7f, float:5.2E-42)
            r51 = 0
            java.lang.String r5 = ""
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r44 = 0
            r45 = 0
            r46 = 0
            r47 = 0
            r48 = 0
            r49 = -4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)
            com.blueair.core.model.Device r3 = (com.blueair.core.model.Device) r3
            r0.updateDevice(r3)
        L_0x020d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getNewUuid(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSsids(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.Ssid>>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getSsids$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getSsids$1 r0 = (com.blueair.api.ConnectionManager$getSsids$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getSsids$1 r0 = new com.blueair.api.ConnectionManager$getSsids$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getSsids$2 r15 = com.blueair.api.ConnectionManager$getSsids$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanProvisionLocal
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getSsids(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getOnboardingEvents(int r17, com.blueair.core.model.OnboardingError r18, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceEvent>>> r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$getOnboardingEvents$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$getOnboardingEvents$1 r2 = (com.blueair.api.ConnectionManager$getOnboardingEvents$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$getOnboardingEvents$1 r2 = new com.blueair.api.ConnectionManager$getOnboardingEvents$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0066
            if (r4 != r5) goto L_0x005e
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$7
            java.lang.Object r11 = r2.L$6
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$5
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$3
            com.blueair.api.client.OnboardingEventsBody r14 = (com.blueair.api.client.OnboardingEventsBody) r14
            java.lang.Object r15 = r2.L$2
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$1
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            java.lang.Object r6 = r2.L$0
            com.blueair.core.model.OnboardingError r6 = (com.blueair.core.model.OnboardingError) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r0 = 1
            goto L_0x0160
        L_0x005e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$getOnboardingEvents$2 r1 = com.blueair.api.ConnectionManager$getOnboardingEvents$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            com.blueair.api.client.OnboardingEventsBody r4 = new com.blueair.api.client.OnboardingEventsBody
            r5 = r17
            r6 = r18
            r4.<init>(r5, r6)
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Attempting to doApiCall "
            r8.<init>(r9)
            r8.append(r1)
            java.lang.String r9 = ", with "
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = " on "
            r8.append(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = " clients"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r9 = 0
            java.lang.Object[] r10 = new java.lang.Object[r9]
            r7.d(r8, r10)
            timber.log.Timber$Forest r7 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r10 = "Client info: "
            r8.<init>(r10)
            java.util.List<com.blueair.api.client.DeviceClient> r10 = r0.clients
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r10 = new java.lang.Object[r9]
            r7.v(r8, r10)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            io.flatcircle.coroutinehelper.Failure r8 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r9 = new java.lang.UnknownError
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "None of the clients in "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r11 = " could call "
            r10.append(r11)
            r10.append(r1)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.<init>(r9)
            r7.element = r8
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x00f6:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x0108
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof com.blueair.api.client.CanProvisionLocal
            if (r11 == 0) goto L_0x00f6
            r9.add(r10)
            goto L_0x00f6
        L_0x0108:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
            r15 = r1
            r14 = r4
            r11 = r8
            r12 = r9
            r4 = 0
            r1 = r0
            r9 = r7
            r7 = 0
        L_0x0118:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01c9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r2.L$0 = r0
            r2.L$1 = r1
            r2.L$2 = r15
            r2.L$3 = r14
            r2.L$4 = r9
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$5 = r0
            r2.L$6 = r11
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$7 = r0
            r2.L$8 = r10
            r2.L$9 = r9
            r2.I$0 = r5
            r2.I$1 = r7
            r2.I$2 = r4
            r0 = 0
            r2.I$3 = r0
            r0 = 1
            r2.label = r0
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x015b
            return r3
        L_0x015b:
            r13 = r5
            r5 = r1
            r1 = r8
            r8 = r13
            r13 = r9
        L_0x0160:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0197
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r9)
            r1.append(r10)
            java.lang.String r2 = " gave good result "
            r1.append(r2)
            T r2 = r13.element
            r1.append(r2)
            java.lang.String r2 = " for call "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            r9 = 0
            java.lang.Object[] r2 = new java.lang.Object[r9]
            r0.v(r1, r2)
            T r0 = r13.element
            return r0
        L_0x0197:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r9)
            r0.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r0.append(r9)
            T r9 = r13.element
            r0.append(r9)
            java.lang.String r9 = " for call \n"
            r0.append(r9)
            r0.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r0.append(r9)
            java.lang.String r0 = r0.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r0, r9)
            r0 = r16
            r1 = r5
            r5 = r8
            r9 = r13
            goto L_0x0118
        L_0x01c9:
            T r0 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Throwable r0 = r0.exceptionOrNull()
            r1.logApiError(r0)
            T r0 = r9.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getOnboardingEvents(int, com.blueair.core.model.OnboardingError, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object provisionDevice(java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.model.ProvisionRequestBody>> r24) {
        /*
            r18 = this;
            r0 = r18
            r1 = r24
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$provisionDevice$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$provisionDevice$1 r2 = (com.blueair.api.ConnectionManager$provisionDevice$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$provisionDevice$1 r2 = new com.blueair.api.ConnectionManager$provisionDevice$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x008f
            if (r4 != r5) goto L_0x0087
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$13
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$12
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$11
            java.lang.Object r10 = r2.L$10
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$9
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$7
            com.blueair.api.client.ProvisionBody r13 = (com.blueair.api.client.ProvisionBody) r13
            java.lang.Object r14 = r2.L$6
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$5
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$4
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r2.L$3
            java.lang.String r6 = (java.lang.String) r6
            r16 = r1
            java.lang.Object r1 = r2.L$2
            java.lang.String r1 = (java.lang.String) r1
            r19 = r1
            java.lang.Object r1 = r2.L$1
            java.lang.String r1 = (java.lang.String) r1
            r20 = r1
            java.lang.Object r1 = r2.L$0
            java.lang.String r1 = (java.lang.String) r1
            kotlin.ResultKt.throwOnFailure(r16)
            r0 = r8
            r8 = r2
            r2 = r14
            r14 = r10
            r10 = r0
            r0 = r1
            r17 = r15
            r1 = r16
            r15 = r11
            r16 = r13
            r11 = r9
            r13 = r12
            r9 = r4
            r12 = r7
            r7 = r5
            r5 = r19
        L_0x0083:
            r4 = r20
            goto L_0x01c5
        L_0x0087:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x008f:
            r16 = r1
            kotlin.ResultKt.throwOnFailure(r16)
            com.blueair.api.ConnectionManager$provisionDevice$2 r1 = com.blueair.api.ConnectionManager$provisionDevice$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            com.blueair.api.client.ProvisionBody r4 = new com.blueair.api.client.ProvisionBody
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r4.<init>(r5, r6, r7, r8, r9)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r7 = ", with "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = " on "
            r6.append(r7)
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r7 = " clients"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.d(r6, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r6.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.v(r6, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " could call "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.<init>(r7)
            r5.element = r6
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r0.clients
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x0127:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0139
            java.lang.Object r8 = r6.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanProvisionLocal
            if (r9 == 0) goto L_0x0127
            r7.add(r8)
            goto L_0x0127
        L_0x0139:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r6 = r7.iterator()
            r15 = r0
            r14 = r1
            r13 = r4
            r10 = r5
            r11 = r6
            r12 = r7
            r8 = 0
            r9 = 0
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r2
            r2 = r20
        L_0x0152:
            r1 = r19
            boolean r16 = r11.hasNext()
            if (r16 == 0) goto L_0x023c
            java.lang.Object r16 = r11.next()
            r0 = r16
            com.blueair.api.client.DeviceClient r0 = (com.blueair.api.client.DeviceClient) r0
            r19 = r1
            r1 = r14
            kotlin.jvm.functions.Function3 r1 = (kotlin.jvm.functions.Function3) r1
            r20 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r19)
            r7.L$0 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
            r7.L$1 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r7.L$2 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
            r7.L$3 = r2
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r7.L$4 = r2
            r7.L$5 = r15
            r7.L$6 = r14
            r7.L$7 = r13
            r7.L$8 = r10
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r7.L$9 = r2
            r7.L$10 = r11
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r16)
            r7.L$11 = r2
            r7.L$12 = r0
            r7.L$13 = r10
            r7.I$0 = r9
            r7.I$1 = r8
            r2 = 0
            r7.I$2 = r2
            r2 = 1
            r7.label = r2
            java.lang.Object r1 = r1.invoke(r0, r13, r7)
            if (r1 != r3) goto L_0x01b2
            return r3
        L_0x01b2:
            r16 = r13
            r2 = r14
            r17 = r15
            r13 = r10
            r14 = r11
            r15 = r12
            r11 = r0
            r12 = r9
            r0 = r19
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            goto L_0x0083
        L_0x01c5:
            r10.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x01fc
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r11)
            java.lang.String r3 = " gave good result "
            r1.append(r3)
            T r3 = r13.element
            r1.append(r3)
            java.lang.String r3 = " for call "
            r1.append(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r0.v(r1, r2)
            T r0 = r13.element
            return r0
        L_0x01fc:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            r19 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            r0.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r0.append(r10)
            T r10 = r13.element
            r0.append(r10)
            java.lang.String r10 = " for call \n"
            r0.append(r10)
            r0.append(r2)
            java.lang.String r10 = ", \nwith details:"
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r11 = 0
            java.lang.Object[] r10 = new java.lang.Object[r11]
            r1.w(r0, r10)
            r0 = r18
            r10 = r13
            r11 = r14
            r13 = r16
            r14 = r2
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r12
            r12 = r15
            r15 = r17
            goto L_0x0152
        L_0x023c:
            T r0 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Throwable r0 = r0.exceptionOrNull()
            r15.logApiError(r0)
            T r0 = r10.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.provisionDevice(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object resetDevice(com.blueair.core.model.DeviceUuid r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.String>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof com.blueair.api.ConnectionManager$resetDevice$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.api.ConnectionManager$resetDevice$1 r3 = (com.blueair.api.ConnectionManager$resetDevice$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.api.ConnectionManager$resetDevice$1 r3 = new com.blueair.api.ConnectionManager$resetDevice$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x0070
            if (r5 != r6) goto L_0x0068
            int r1 = r3.I$2
            int r1 = r3.I$1
            int r5 = r3.I$0
            java.lang.Object r8 = r3.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r3.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r3.L$7
            java.lang.Object r10 = r3.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r3.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r3.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r3.L$3
            com.blueair.core.model.DeviceUuid r13 = (com.blueair.core.model.DeviceUuid) r13
            java.lang.Object r14 = r3.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r3.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r6 = r3.L$0
            com.blueair.core.model.DeviceUuid r6 = (com.blueair.core.model.DeviceUuid) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r1
            r1 = r13
            r13 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r5
            r5 = r7
            r7 = 1
            goto L_0x0174
        L_0x0068:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 != 0) goto L_0x0085
            io.flatcircle.coroutinehelper.ApiResult$Companion r1 = io.flatcircle.coroutinehelper.ApiResult.Companion
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "deviceUuid should be filled in"
            r2.<init>(r3)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            io.flatcircle.coroutinehelper.ApiResult r1 = r1.fail(r2)
            return r1
        L_0x0085:
            com.blueair.api.ConnectionManager$resetDevice$2 r2 = com.blueair.api.ConnectionManager$resetDevice$2.INSTANCE
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r6.<init>(r8)
            r6.append(r2)
            java.lang.String r8 = ", with "
            r6.append(r8)
            r6.append(r1)
            java.lang.String r8 = " on "
            r6.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r6.append(r8)
            java.lang.String r8 = " clients"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.d(r6, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r6.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.v(r6, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r6.<init>(r8)
            r5.element = r6
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r0.clients
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r6 = r6.iterator()
        L_0x0108:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x011a
            java.lang.Object r9 = r6.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanProvisionLocal
            if (r10 == 0) goto L_0x0108
            r8.add(r9)
            goto L_0x0108
        L_0x011a:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r6 = r8.iterator()
            r15 = r0
            r14 = r2
            r10 = r6
            r6 = r7
            r11 = r8
            r2 = r1
            r8 = r5
            r5 = r3
            r3 = r6
        L_0x012b:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01de
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r5.L$0 = r7
            r5.L$1 = r15
            r5.L$2 = r14
            r5.L$3 = r1
            r5.L$4 = r8
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r5.L$5 = r7
            r5.L$6 = r10
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r5.L$7 = r7
            r5.L$8 = r12
            r5.L$9 = r8
            r5.I$0 = r6
            r5.I$1 = r3
            r7 = 0
            r5.I$2 = r7
            r7 = 1
            r5.label = r7
            java.lang.Object r9 = r13.invoke(r12, r1, r5)
            if (r9 != r4) goto L_0x016c
            return r4
        L_0x016c:
            r13 = r11
            r11 = r10
            r10 = r12
            r12 = r8
            r8 = r6
            r6 = r2
            r2 = r9
            r9 = r12
        L_0x0174:
            r9.element = r2
            T r2 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isSuccess()
            java.lang.String r9 = "client "
            if (r2 == 0) goto L_0x01ab
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r7 = 0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x01ab:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r7.append(r9)
            T r9 = r12.element
            r7.append(r9)
            java.lang.String r9 = " for call \n"
            r7.append(r9)
            r7.append(r14)
            java.lang.String r9 = ", \nwith details:"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r9 = 0
            java.lang.Object[] r10 = new java.lang.Object[r9]
            r2.w(r7, r10)
            r2 = r6
            r6 = r8
            r7 = r9
            r10 = r11
            r8 = r12
            r11 = r13
            goto L_0x012b
        L_0x01de:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.resetDevice(com.blueair.core.model.DeviceUuid, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object switchOffSoftAp(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$switchOffSoftAp$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$switchOffSoftAp$1 r0 = (com.blueair.api.ConnectionManager$switchOffSoftAp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$switchOffSoftAp$1 r0 = new com.blueair.api.ConnectionManager$switchOffSoftAp$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$switchOffSoftAp$2 r15 = com.blueair.api.ConnectionManager$switchOffSoftAp$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanProvisionLocal
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.switchOffSoftAp(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLatestSensorData(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.core.model.IndoorDatapoint>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getLatestSensorData$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getLatestSensorData$1 r0 = (com.blueair.api.ConnectionManager$getLatestSensorData$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getLatestSensorData$1 r0 = new com.blueair.api.ConnectionManager$getLatestSensorData$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getLatestSensorData$2 r15 = com.blueair.api.ConnectionManager$getLatestSensorData$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanGetSensorData
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getLatestSensorData(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getMonthSensorData(long r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.IndoorDatapoint>>> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$getMonthSensorData$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$getMonthSensorData$1 r2 = (com.blueair.api.ConnectionManager$getMonthSensorData$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$getMonthSensorData$1 r2 = new com.blueair.api.ConnectionManager$getMonthSensorData$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0068
            if (r4 != r5) goto L_0x0060
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            long r8 = r2.J$0
            java.lang.Object r10 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$7
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$6
            java.lang.Object r12 = r2.L$5
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$4
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$2
            java.lang.Long r15 = (java.lang.Long) r15
            java.lang.Object r5 = r2.L$1
            kotlin.reflect.KFunction r5 = (kotlin.reflect.KFunction) r5
            java.lang.Object r6 = r2.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r0 = r4
            r4 = r2
            r2 = r7
            r7 = r6
            r6 = r5
            r5 = r0
            r0 = 1
            goto L_0x015c
        L_0x0060:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$getMonthSensorData$2 r1 = com.blueair.api.ConnectionManager$getMonthSensorData$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r19)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r7 = ", with "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = " on "
            r6.append(r7)
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r7 = " clients"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.d(r6, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r6.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.v(r6, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " could call "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.<init>(r7)
            r5.element = r6
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r0.clients
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x00f3:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0105
            java.lang.Object r8 = r6.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanGetSensorData
            if (r9 == 0) goto L_0x00f3
            r7.add(r8)
            goto L_0x00f3
        L_0x0105:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r6 = r7.iterator()
            r15 = r4
            r10 = r5
            r12 = r6
            r13 = r7
            r5 = 0
            r8 = 0
            r7 = r0
            r6 = r1
            r4 = r2
            r1 = r19
        L_0x0118:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x01c8
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r6
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r4.L$0 = r7
            r4.L$1 = r6
            r4.L$2 = r15
            r4.L$3 = r10
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$4 = r0
            r4.L$5 = r12
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$6 = r0
            r4.L$7 = r11
            r4.L$8 = r10
            r4.J$0 = r1
            r4.I$0 = r8
            r4.I$1 = r5
            r0 = 0
            r4.I$2 = r0
            r0 = 1
            r4.label = r0
            java.lang.Object r9 = r14.invoke(r11, r15, r4)
            if (r9 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r14 = r10
            r16 = r1
            r2 = r8
            r1 = r9
            r8 = r16
        L_0x015c:
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x0193
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r11)
            java.lang.String r2 = " gave good result "
            r1.append(r2)
            T r2 = r14.element
            r1.append(r2)
            java.lang.String r2 = " for call "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r7 = 0
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r0.v(r1, r2)
            T r0 = r14.element
            return r0
        L_0x0193:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            r0.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r0.append(r10)
            T r10 = r14.element
            r0.append(r10)
            java.lang.String r10 = " for call \n"
            r0.append(r10)
            r0.append(r6)
            java.lang.String r10 = ", \nwith details:"
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r11 = 0
            java.lang.Object[] r10 = new java.lang.Object[r11]
            r1.w(r0, r10)
            r16 = r8
            r8 = r2
            r1 = r16
            r0 = r18
            r10 = r14
            goto L_0x0118
        L_0x01c8:
            T r0 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Throwable r0 = r0.exceptionOrNull()
            r7.logApiError(r0)
            T r0 = r10.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getMonthSensorData(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAttributes(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.api.restapi.DeviceAttributeOnAbl>>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getAttributes$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getAttributes$1 r0 = (com.blueair.api.ConnectionManager$getAttributes$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getAttributes$1 r0 = new com.blueair.api.ConnectionManager$getAttributes$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getAttributes$2 r15 = com.blueair.api.ConnectionManager$getAttributes$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanGetAttributes
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getAttributes(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getIsUpdating(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Boolean>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getIsUpdating$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getIsUpdating$1 r0 = (com.blueair.api.ConnectionManager$getIsUpdating$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getIsUpdating$1 r0 = new com.blueair.api.ConnectionManager$getIsUpdating$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getIsUpdating$2 r15 = com.blueair.api.ConnectionManager$getIsUpdating$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanGetAttributes
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getIsUpdating(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setFanSpeed(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setFanSpeed$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setFanSpeed$1 r2 = (com.blueair.api.ConnectionManager$setFanSpeed$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setFanSpeed$1 r2 = new com.blueair.api.ConnectionManager$setFanSpeed$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setFanSpeed$2 r1 = com.blueair.api.ConnectionManager$setFanSpeed$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetFan
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setFanSpeed(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setAutoMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof com.blueair.api.ConnectionManager$setAutoMode$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.api.ConnectionManager$setAutoMode$1 r3 = (com.blueair.api.ConnectionManager$setAutoMode$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.api.ConnectionManager$setAutoMode$1 r3 = new com.blueair.api.ConnectionManager$setAutoMode$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x006b
            if (r5 != r6) goto L_0x0063
            int r1 = r3.I$3
            int r1 = r3.I$2
            int r5 = r3.I$1
            int r8 = r3.I$0
            java.lang.Object r9 = r3.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r3.L$6
            java.lang.Object r11 = r3.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r3.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r6 = r3.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r1
            r1 = r8
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = 1
            goto L_0x0160
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 < 0) goto L_0x01d8
            r2 = 2
            if (r1 >= r2) goto L_0x01d8
            com.blueair.api.ConnectionManager$setAutoMode$2 r2 = com.blueair.api.ConnectionManager$setAutoMode$2.INSTANCE
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Attempting to doApiCall "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r9 = ", with "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " on "
            r8.append(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = " clients"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.d(r8, r9)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Client info: "
            r8.<init>(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.v(r8, r9)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            io.flatcircle.coroutinehelper.Failure r8 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r9 = new java.lang.UnknownError
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "None of the clients in "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r11 = " could call "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.<init>(r9)
            r6.element = r8
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x00fa:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof com.blueair.api.client.CanSetFan
            if (r11 == 0) goto L_0x00fa
            r9.add(r10)
            goto L_0x00fa
        L_0x010c:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
            r15 = r2
            r14 = r5
            r2 = r7
            r5 = r2
            r11 = r8
            r12 = r9
            r9 = r6
            r6 = r0
        L_0x011c:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01ca
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r3.L$0 = r6
            r3.L$1 = r15
            r3.L$2 = r14
            r3.L$3 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$4 = r7
            r3.L$5 = r11
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$6 = r7
            r3.L$7 = r10
            r3.L$8 = r9
            r3.I$0 = r1
            r3.I$1 = r5
            r3.I$2 = r2
            r7 = 0
            r3.I$3 = r7
            r7 = 1
            r3.label = r7
            java.lang.Object r8 = r13.invoke(r10, r14, r3)
            if (r8 != r4) goto L_0x0159
            return r4
        L_0x0159:
            r13 = r3
            r3 = r2
            r2 = r8
            r8 = r6
            r6 = r5
            r5 = r13
            r13 = r9
        L_0x0160:
            r9.element = r2
            T r2 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isSuccess()
            java.lang.String r9 = "client "
            if (r2 == 0) goto L_0x0197
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r7 = 0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0197:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r7.append(r9)
            T r9 = r13.element
            r7.append(r9)
            java.lang.String r9 = " for call \n"
            r7.append(r9)
            r7.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r2.w(r7, r9)
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r8
            r7 = r10
            r9 = r13
            goto L_0x011c
        L_0x01ca:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r6.logApiError(r1)
            T r1 = r9.element
            return r1
        L_0x01d8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Failed requirement."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setAutoMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object resetAutoModeDependency(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$resetAutoModeDependency$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$resetAutoModeDependency$1 r0 = (com.blueair.api.ConnectionManager$resetAutoModeDependency$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$resetAutoModeDependency$1 r0 = new com.blueair.api.ConnectionManager$resetAutoModeDependency$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$resetAutoModeDependency$2 r15 = com.blueair.api.ConnectionManager$resetAutoModeDependency$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanSetAutoModeDependency
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.resetAutoModeDependency(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setAutoModeDependency(java.lang.Object r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setAutoModeDependency$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setAutoModeDependency$1 r2 = (com.blueair.api.ConnectionManager$setAutoModeDependency$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setAutoModeDependency$1 r2 = new com.blueair.api.ConnectionManager$setAutoModeDependency$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0061
            if (r4 != r5) goto L_0x0059
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x0059:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setAutoModeDependency$2 r1 = com.blueair.api.ConnectionManager$setAutoModeDependency$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00e9:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00fb
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetAutoModeDependency
            if (r10 == 0) goto L_0x00e9
            r8.add(r9)
            goto L_0x00e9
        L_0x00fb:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010b:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bb
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x014c
            return r3
        L_0x014c:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0152:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010b
        L_0x01bb:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setAutoModeDependency(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setBrightness(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setBrightness$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setBrightness$1 r2 = (com.blueair.api.ConnectionManager$setBrightness$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setBrightness$1 r2 = new com.blueair.api.ConnectionManager$setBrightness$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setBrightness$2 r1 = com.blueair.api.ConnectionManager$setBrightness$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetBrightness
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setBrightness(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setChildLock(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof com.blueair.api.ConnectionManager$setChildLock$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.api.ConnectionManager$setChildLock$1 r3 = (com.blueair.api.ConnectionManager$setChildLock$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.api.ConnectionManager$setChildLock$1 r3 = new com.blueair.api.ConnectionManager$setChildLock$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x006b
            if (r5 != r6) goto L_0x0063
            int r1 = r3.I$3
            int r1 = r3.I$2
            int r5 = r3.I$1
            int r8 = r3.I$0
            java.lang.Object r9 = r3.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r3.L$6
            java.lang.Object r11 = r3.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r3.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r6 = r3.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r1
            r1 = r8
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = 1
            goto L_0x0160
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 < 0) goto L_0x01d8
            r2 = 2
            if (r1 >= r2) goto L_0x01d8
            com.blueair.api.ConnectionManager$setChildLock$2 r2 = com.blueair.api.ConnectionManager$setChildLock$2.INSTANCE
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Attempting to doApiCall "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r9 = ", with "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " on "
            r8.append(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = " clients"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.d(r8, r9)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Client info: "
            r8.<init>(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.v(r8, r9)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            io.flatcircle.coroutinehelper.Failure r8 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r9 = new java.lang.UnknownError
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "None of the clients in "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r11 = " could call "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.<init>(r9)
            r6.element = r8
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x00fa:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof com.blueair.api.client.CanSetChildLock
            if (r11 == 0) goto L_0x00fa
            r9.add(r10)
            goto L_0x00fa
        L_0x010c:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
            r15 = r2
            r14 = r5
            r2 = r7
            r5 = r2
            r11 = r8
            r12 = r9
            r9 = r6
            r6 = r0
        L_0x011c:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01ca
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r3.L$0 = r6
            r3.L$1 = r15
            r3.L$2 = r14
            r3.L$3 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$4 = r7
            r3.L$5 = r11
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$6 = r7
            r3.L$7 = r10
            r3.L$8 = r9
            r3.I$0 = r1
            r3.I$1 = r5
            r3.I$2 = r2
            r7 = 0
            r3.I$3 = r7
            r7 = 1
            r3.label = r7
            java.lang.Object r8 = r13.invoke(r10, r14, r3)
            if (r8 != r4) goto L_0x0159
            return r4
        L_0x0159:
            r13 = r3
            r3 = r2
            r2 = r8
            r8 = r6
            r6 = r5
            r5 = r13
            r13 = r9
        L_0x0160:
            r9.element = r2
            T r2 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isSuccess()
            java.lang.String r9 = "client "
            if (r2 == 0) goto L_0x0197
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r7 = 0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0197:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r7.append(r9)
            T r9 = r13.element
            r7.append(r9)
            java.lang.String r9 = " for call \n"
            r7.append(r9)
            r7.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r2.w(r7, r9)
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r8
            r7 = r10
            r9 = r13
            goto L_0x011c
        L_0x01ca:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r6.logApiError(r1)
            T r1 = r9.element
            return r1
        L_0x01d8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Failed requirement."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setChildLock(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setDisinfection(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setDisinfection$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setDisinfection$1 r2 = (com.blueair.api.ConnectionManager$setDisinfection$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setDisinfection$1 r2 = new com.blueair.api.ConnectionManager$setDisinfection$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setDisinfection$2 r1 = com.blueair.api.ConnectionManager$setDisinfection$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetDisinfection
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setDisinfection(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLinkedUid(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<java.lang.String>>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getLinkedUid$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getLinkedUid$1 r0 = (com.blueair.api.ConnectionManager$getLinkedUid$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getLinkedUid$1 r0 = new com.blueair.api.ConnectionManager$getLinkedUid$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getLinkedUid$2 r15 = com.blueair.api.ConnectionManager$getLinkedUid$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanLinkWithAware
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getLinkedUid(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setLinkedUid(java.lang.String r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setLinkedUid$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setLinkedUid$1 r2 = (com.blueair.api.ConnectionManager$setLinkedUid$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setLinkedUid$1 r2 = new com.blueair.api.ConnectionManager$setLinkedUid$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setLinkedUid$2 r1 = com.blueair.api.ConnectionManager$setLinkedUid$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanLinkWithAware
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setLinkedUid(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setStandBy(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof com.blueair.api.ConnectionManager$setStandBy$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.api.ConnectionManager$setStandBy$1 r3 = (com.blueair.api.ConnectionManager$setStandBy$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.api.ConnectionManager$setStandBy$1 r3 = new com.blueair.api.ConnectionManager$setStandBy$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x006b
            if (r5 != r6) goto L_0x0063
            int r1 = r3.I$3
            int r1 = r3.I$2
            int r5 = r3.I$1
            int r8 = r3.I$0
            java.lang.Object r9 = r3.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r3.L$6
            java.lang.Object r11 = r3.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r3.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r6 = r3.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r1
            r1 = r8
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = 1
            goto L_0x0160
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 < 0) goto L_0x01d8
            r2 = 2
            if (r1 >= r2) goto L_0x01d8
            com.blueair.api.ConnectionManager$setStandBy$2 r2 = com.blueair.api.ConnectionManager$setStandBy$2.INSTANCE
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Attempting to doApiCall "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r9 = ", with "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " on "
            r8.append(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = " clients"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.d(r8, r9)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Client info: "
            r8.<init>(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.v(r8, r9)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            io.flatcircle.coroutinehelper.Failure r8 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r9 = new java.lang.UnknownError
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "None of the clients in "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r11 = " could call "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.<init>(r9)
            r6.element = r8
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x00fa:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof com.blueair.api.client.CanSetStandBy
            if (r11 == 0) goto L_0x00fa
            r9.add(r10)
            goto L_0x00fa
        L_0x010c:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
            r15 = r2
            r14 = r5
            r2 = r7
            r5 = r2
            r11 = r8
            r12 = r9
            r9 = r6
            r6 = r0
        L_0x011c:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01ca
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r3.L$0 = r6
            r3.L$1 = r15
            r3.L$2 = r14
            r3.L$3 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$4 = r7
            r3.L$5 = r11
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$6 = r7
            r3.L$7 = r10
            r3.L$8 = r9
            r3.I$0 = r1
            r3.I$1 = r5
            r3.I$2 = r2
            r7 = 0
            r3.I$3 = r7
            r7 = 1
            r3.label = r7
            java.lang.Object r8 = r13.invoke(r10, r14, r3)
            if (r8 != r4) goto L_0x0159
            return r4
        L_0x0159:
            r13 = r3
            r3 = r2
            r2 = r8
            r8 = r6
            r6 = r5
            r5 = r13
            r13 = r9
        L_0x0160:
            r9.element = r2
            T r2 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isSuccess()
            java.lang.String r9 = "client "
            if (r2 == 0) goto L_0x0197
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r7 = 0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0197:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r7.append(r9)
            T r9 = r13.element
            r7.append(r9)
            java.lang.String r9 = " for call \n"
            r7.append(r9)
            r7.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r2.w(r7, r9)
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r8
            r7 = r10
            r9 = r13
            goto L_0x011c
        L_0x01ca:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r6.logApiError(r1)
            T r1 = r9.element
            return r1
        L_0x01d8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Failed requirement."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setStandBy(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setEcoMode(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setEcoMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setEcoMode$1 r2 = (com.blueair.api.ConnectionManager$setEcoMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setEcoMode$1 r2 = new com.blueair.api.ConnectionManager$setEcoMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setEcoMode$2 r1 = com.blueair.api.ConnectionManager$setEcoMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetEcoMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setEcoMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHinsMode(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHinsMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHinsMode$1 r2 = (com.blueair.api.ConnectionManager$setHinsMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHinsMode$1 r2 = new com.blueair.api.ConnectionManager$setHinsMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHinsMode$2 r1 = com.blueair.api.ConnectionManager$setHinsMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetHinsMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHinsMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHinsNightMode(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHinsNightMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHinsNightMode$1 r2 = (com.blueair.api.ConnectionManager$setHinsNightMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHinsNightMode$1 r2 = new com.blueair.api.ConnectionManager$setHinsNightMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHinsNightMode$2 r1 = com.blueair.api.ConnectionManager$setHinsNightMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetHinsMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHinsNightMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setG4NightMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof com.blueair.api.ConnectionManager$setG4NightMode$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.api.ConnectionManager$setG4NightMode$1 r3 = (com.blueair.api.ConnectionManager$setG4NightMode$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.api.ConnectionManager$setG4NightMode$1 r3 = new com.blueair.api.ConnectionManager$setG4NightMode$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x006b
            if (r5 != r6) goto L_0x0063
            int r1 = r3.I$3
            int r1 = r3.I$2
            int r5 = r3.I$1
            int r8 = r3.I$0
            java.lang.Object r9 = r3.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r3.L$6
            java.lang.Object r11 = r3.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r3.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r6 = r3.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r1
            r1 = r8
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = 1
            goto L_0x0160
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 < 0) goto L_0x01d8
            r2 = 2
            if (r1 >= r2) goto L_0x01d8
            com.blueair.api.ConnectionManager$setG4NightMode$2 r2 = com.blueair.api.ConnectionManager$setG4NightMode$2.INSTANCE
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Attempting to doApiCall "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r9 = ", with "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " on "
            r8.append(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = " clients"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.d(r8, r9)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Client info: "
            r8.<init>(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.v(r8, r9)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            io.flatcircle.coroutinehelper.Failure r8 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r9 = new java.lang.UnknownError
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "None of the clients in "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r11 = " could call "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.<init>(r9)
            r6.element = r8
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x00fa:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof com.blueair.api.client.CanSetG4NightMode
            if (r11 == 0) goto L_0x00fa
            r9.add(r10)
            goto L_0x00fa
        L_0x010c:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
            r15 = r2
            r14 = r5
            r2 = r7
            r5 = r2
            r11 = r8
            r12 = r9
            r9 = r6
            r6 = r0
        L_0x011c:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01ca
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r3.L$0 = r6
            r3.L$1 = r15
            r3.L$2 = r14
            r3.L$3 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$4 = r7
            r3.L$5 = r11
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$6 = r7
            r3.L$7 = r10
            r3.L$8 = r9
            r3.I$0 = r1
            r3.I$1 = r5
            r3.I$2 = r2
            r7 = 0
            r3.I$3 = r7
            r7 = 1
            r3.label = r7
            java.lang.Object r8 = r13.invoke(r10, r14, r3)
            if (r8 != r4) goto L_0x0159
            return r4
        L_0x0159:
            r13 = r3
            r3 = r2
            r2 = r8
            r8 = r6
            r6 = r5
            r5 = r13
            r13 = r9
        L_0x0160:
            r9.element = r2
            T r2 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isSuccess()
            java.lang.String r9 = "client "
            if (r2 == 0) goto L_0x0197
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r7 = 0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0197:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r7.append(r9)
            T r9 = r13.element
            r7.append(r9)
            java.lang.String r9 = " for call \n"
            r7.append(r9)
            r7.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r2.w(r7, r9)
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r8
            r7 = r10
            r9 = r13
            goto L_0x011c
        L_0x01ca:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r6.logApiError(r1)
            T r1 = r9.element
            return r1
        L_0x01d8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Failed requirement."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setG4NightMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setGermShieldMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            boolean r3 = r2 instanceof com.blueair.api.ConnectionManager$setGermShieldMode$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.blueair.api.ConnectionManager$setGermShieldMode$1 r3 = (com.blueair.api.ConnectionManager$setGermShieldMode$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.blueair.api.ConnectionManager$setGermShieldMode$1 r3 = new com.blueair.api.ConnectionManager$setGermShieldMode$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 1
            r7 = 0
            if (r5 == 0) goto L_0x006b
            if (r5 != r6) goto L_0x0063
            int r1 = r3.I$3
            int r1 = r3.I$2
            int r5 = r3.I$1
            int r8 = r3.I$0
            java.lang.Object r9 = r3.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r3.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r3.L$6
            java.lang.Object r11 = r3.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r3.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r3.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r3.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r6 = r3.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r7 = r3
            r3 = r1
            r1 = r8
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = 1
            goto L_0x0160
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r2)
            if (r1 < 0) goto L_0x01d8
            r2 = 2
            if (r1 >= r2) goto L_0x01d8
            com.blueair.api.ConnectionManager$setGermShieldMode$2 r2 = com.blueair.api.ConnectionManager$setGermShieldMode$2.INSTANCE
            kotlin.reflect.KFunction r2 = (kotlin.reflect.KFunction) r2
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Attempting to doApiCall "
            r8.<init>(r9)
            r8.append(r2)
            java.lang.String r9 = ", with "
            r8.append(r9)
            r8.append(r5)
            java.lang.String r9 = " on "
            r8.append(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            int r9 = r9.size()
            r8.append(r9)
            java.lang.String r9 = " clients"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.d(r8, r9)
            timber.log.Timber$Forest r6 = timber.log.Timber.Forest
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "Client info: "
            r8.<init>(r9)
            java.util.List<com.blueair.api.client.DeviceClient> r9 = r0.clients
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r9 = new java.lang.Object[r7]
            r6.v(r8, r9)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            io.flatcircle.coroutinehelper.Failure r8 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r9 = new java.lang.UnknownError
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "None of the clients in "
            r10.<init>(r11)
            r10.append(r0)
            java.lang.String r11 = " could call "
            r10.append(r11)
            r10.append(r2)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            r8.<init>(r9)
            r6.element = r8
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Collection r9 = (java.util.Collection) r9
            java.util.Iterator r8 = r8.iterator()
        L_0x00fa:
            boolean r10 = r8.hasNext()
            if (r10 == 0) goto L_0x010c
            java.lang.Object r10 = r8.next()
            boolean r11 = r10 instanceof com.blueair.api.client.CanSetGermShieldMode
            if (r11 == 0) goto L_0x00fa
            r9.add(r10)
            goto L_0x00fa
        L_0x010c:
            java.util.List r9 = (java.util.List) r9
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r8 = r9.iterator()
            r15 = r2
            r14 = r5
            r2 = r7
            r5 = r2
            r11 = r8
            r12 = r9
            r9 = r6
            r6 = r0
        L_0x011c:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01ca
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r3.L$0 = r6
            r3.L$1 = r15
            r3.L$2 = r14
            r3.L$3 = r9
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r3.L$4 = r7
            r3.L$5 = r11
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r3.L$6 = r7
            r3.L$7 = r10
            r3.L$8 = r9
            r3.I$0 = r1
            r3.I$1 = r5
            r3.I$2 = r2
            r7 = 0
            r3.I$3 = r7
            r7 = 1
            r3.label = r7
            java.lang.Object r8 = r13.invoke(r10, r14, r3)
            if (r8 != r4) goto L_0x0159
            return r4
        L_0x0159:
            r13 = r3
            r3 = r2
            r2 = r8
            r8 = r6
            r6 = r5
            r5 = r13
            r13 = r9
        L_0x0160:
            r9.element = r2
            T r2 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r2 = (io.flatcircle.coroutinehelper.ApiResult) r2
            boolean r2 = r2.isSuccess()
            java.lang.String r9 = "client "
            if (r2 == 0) goto L_0x0197
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r7 = 0
            java.lang.Object[] r3 = new java.lang.Object[r7]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0197:
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r9)
            r7.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r7.append(r9)
            T r9 = r13.element
            r7.append(r9)
            java.lang.String r9 = " for call \n"
            r7.append(r9)
            r7.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r2.w(r7, r9)
            r2 = r3
            r3 = r5
            r5 = r6
            r6 = r8
            r7 = r10
            r9 = r13
            goto L_0x011c
        L_0x01ca:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r6.logApiError(r1)
            T r1 = r9.element
            return r1
        L_0x01d8:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Failed requirement."
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setGermShieldMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setGermShieldNightMode(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setGermShieldNightMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setGermShieldNightMode$1 r2 = (com.blueair.api.ConnectionManager$setGermShieldNightMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setGermShieldNightMode$1 r2 = new com.blueair.api.ConnectionManager$setGermShieldNightMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setGermShieldNightMode$2 r1 = com.blueair.api.ConnectionManager$setGermShieldNightMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetGermShieldMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setGermShieldNightMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setWickDryEnabled(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setWickDryEnabled$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setWickDryEnabled$1 r2 = (com.blueair.api.ConnectionManager$setWickDryEnabled$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setWickDryEnabled$1 r2 = new com.blueair.api.ConnectionManager$setWickDryEnabled$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setWickDryEnabled$2 r1 = com.blueair.api.ConnectionManager$setWickDryEnabled$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetWick
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setWickDryEnabled(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setWickDryOn(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setWickDryOn$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setWickDryOn$1 r2 = (com.blueair.api.ConnectionManager$setWickDryOn$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setWickDryOn$1 r2 = new com.blueair.api.ConnectionManager$setWickDryOn$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setWickDryOn$2 r1 = com.blueair.api.ConnectionManager$setWickDryOn$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetWick
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setWickDryOn(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object cancelWickDryMode(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$cancelWickDryMode$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$cancelWickDryMode$1 r0 = (com.blueair.api.ConnectionManager$cancelWickDryMode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$cancelWickDryMode$1 r0 = new com.blueair.api.ConnectionManager$cancelWickDryMode$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$cancelWickDryMode$2 r15 = com.blueair.api.ConnectionManager$cancelWickDryMode$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanSetWick
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.cancelWickDryMode(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setWickdryDurationAndOn(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setWickdryDurationAndOn$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setWickdryDurationAndOn$1 r2 = (com.blueair.api.ConnectionManager$setWickdryDurationAndOn$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setWickdryDurationAndOn$1 r2 = new com.blueair.api.ConnectionManager$setWickdryDurationAndOn$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setWickdryDurationAndOn$2 r1 = com.blueair.api.ConnectionManager$setWickdryDurationAndOn$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetWick
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setWickdryDurationAndOn(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setAutoRh(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setAutoRh$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setAutoRh$1 r2 = (com.blueair.api.ConnectionManager$setAutoRh$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setAutoRh$1 r2 = new com.blueair.api.ConnectionManager$setAutoRh$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setAutoRh$2 r1 = com.blueair.api.ConnectionManager$setAutoRh$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetAutoRh
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setAutoRh(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setTimerStatus(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setTimerStatus$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setTimerStatus$1 r2 = (com.blueair.api.ConnectionManager$setTimerStatus$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setTimerStatus$1 r2 = new com.blueair.api.ConnectionManager$setTimerStatus$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setTimerStatus$2 r1 = com.blueair.api.ConnectionManager$setTimerStatus$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetTimer
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setTimerStatus(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setTimerDuration(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setTimerDuration$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setTimerDuration$1 r2 = (com.blueair.api.ConnectionManager$setTimerDuration$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setTimerDuration$1 r2 = new com.blueair.api.ConnectionManager$setTimerDuration$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setTimerDuration$2 r1 = com.blueair.api.ConnectionManager$setTimerDuration$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetTimer
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setTimerDuration(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setTimerDurationAndStatus(int r18, int r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setTimerDurationAndStatus$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setTimerDurationAndStatus$1 r2 = (com.blueair.api.ConnectionManager$setTimerDurationAndStatus$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setTimerDurationAndStatus$1 r2 = new com.blueair.api.ConnectionManager$setTimerDurationAndStatus$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 != r5) goto L_0x0061
            int r4 = r2.I$5
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r7 = r2.I$2
            int r8 = r2.I$1
            int r9 = r2.I$0
            java.lang.Object r10 = r2.L$7
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$6
            com.blueair.api.client.CanSetTimer r11 = (com.blueair.api.client.CanSetTimer) r11
            java.lang.Object r11 = r2.L$5
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Object r12 = r2.L$3
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$0
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r8
            r8 = r7
            r7 = r16
            goto L_0x0119
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetTimer> r9 = com.blueair.api.client.CanSetTimer.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00ae:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c0
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetTimer
            if (r9 == 0) goto L_0x00ae
            r7.add(r8)
            goto L_0x00ae
        L_0x00c0:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r15 = r0
            r10 = r1
            r12 = r4
            r8 = r6
            r13 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00d3:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x0175
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r11
            com.blueair.api.client.CanSetTimer r14 = (com.blueair.api.client.CanSetTimer) r14
            r4.L$0 = r15
            r4.L$1 = r10
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$2 = r5
            r4.L$3 = r12
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$4 = r5
            r4.L$5 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r4.L$6 = r5
            r4.L$7 = r10
            r4.I$0 = r1
            r4.I$1 = r2
            r4.I$2 = r8
            r4.I$3 = r7
            r4.I$4 = r6
            r4.I$5 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r9 = r14.setTimerDurationAndStatus(r1, r2, r4)
            if (r9 != r3) goto L_0x0115
            return r3
        L_0x0115:
            r14 = r9
            r9 = r1
            r1 = r14
            r14 = r10
        L_0x0119:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x014e
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r14.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r14.element
            return r1
        L_0x014e:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r14.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r9
            r10 = r14
            r5 = 1
            goto L_0x00d3
        L_0x0175:
            T r1 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r10.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setTimerDurationAndStatus(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setTemperatureUnit(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setTemperatureUnit$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setTemperatureUnit$1 r2 = (com.blueair.api.ConnectionManager$setTemperatureUnit$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setTemperatureUnit$1 r2 = new com.blueair.api.ConnectionManager$setTemperatureUnit$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setTemperatureUnit$2 r1 = com.blueair.api.ConnectionManager$setTemperatureUnit$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetTemperatureUnit
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setTemperatureUnit(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setOscillationState(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setOscillationState$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setOscillationState$1 r2 = (com.blueair.api.ConnectionManager$setOscillationState$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setOscillationState$1 r2 = new com.blueair.api.ConnectionManager$setOscillationState$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setOscillationState$2 r1 = com.blueair.api.ConnectionManager$setOscillationState$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetOscillation
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setOscillationState(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setOscillationParams(int r17, int r18, int r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setOscillationParams$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setOscillationParams$1 r2 = (com.blueair.api.ConnectionManager$setOscillationParams$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setOscillationParams$1 r2 = new com.blueair.api.ConnectionManager$setOscillationParams$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x006b
            if (r4 != r5) goto L_0x0063
            int r4 = r2.I$6
            int r4 = r2.I$5
            int r4 = r2.I$4
            int r7 = r2.I$3
            int r8 = r2.I$2
            int r9 = r2.I$1
            int r10 = r2.I$0
            java.lang.Object r11 = r2.L$7
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11
            java.lang.Object r12 = r2.L$6
            com.blueair.api.client.CanSetOscillation r12 = (com.blueair.api.client.CanSetOscillation) r12
            java.lang.Object r12 = r2.L$5
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            java.lang.Object r13 = r2.L$4
            java.lang.Object r13 = r2.L$3
            java.util.Iterator r13 = (java.util.Iterator) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.lang.Object r15 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r15 = (kotlin.jvm.internal.Ref.ObjectRef) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = r5
            r5 = r2
            r2 = r9
            r9 = r7
            r7 = r4
            r4 = r8
            r8 = r6
            r6 = 1
            goto L_0x0120
        L_0x0063:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r5 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r0)
            java.lang.String r8 = " is "
            r7.append(r8)
            java.lang.Class<com.blueair.api.client.CanSetOscillation> r8 = com.blueair.api.client.CanSetOscillation.class
            kotlin.reflect.KClass r8 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r8)
            java.lang.String r8 = r8.getQualifiedName()
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r5.<init>(r7)
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r4.<init>(r5)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x00b0:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x00c2
            java.lang.Object r7 = r4.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanSetOscillation
            if (r8 == 0) goto L_0x00b0
            r5.add(r7)
            goto L_0x00b0
        L_0x00c2:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r4 = r5.iterator()
            r8 = r0
            r11 = r1
            r13 = r4
            r14 = r5
            r7 = 0
            r9 = 0
            r1 = r17
            r4 = r19
            r5 = r2
            r2 = r18
        L_0x00d7:
            boolean r10 = r13.hasNext()
            if (r10 == 0) goto L_0x017d
            java.lang.Object r10 = r13.next()
            r12 = r10
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r15 = r12
            com.blueair.api.client.CanSetOscillation r15 = (com.blueair.api.client.CanSetOscillation) r15
            r5.L$0 = r8
            r5.L$1 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r5.L$2 = r6
            r5.L$3 = r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r5.L$4 = r6
            r5.L$5 = r12
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r5.L$6 = r6
            r5.L$7 = r11
            r5.I$0 = r1
            r5.I$1 = r2
            r5.I$2 = r4
            r5.I$3 = r9
            r5.I$4 = r7
            r6 = 0
            r5.I$5 = r6
            r5.I$6 = r6
            r6 = 1
            r5.label = r6
            java.lang.Object r10 = r15.setOscillationParams(r1, r2, r4, r5)
            if (r10 != r3) goto L_0x011c
            return r3
        L_0x011c:
            r15 = r10
            r10 = r1
            r1 = r15
            r15 = r11
        L_0x0120:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r11.element = r1
            T r1 = r15.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r11 = "client "
            if (r1 == 0) goto L_0x0156
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r11)
            r2.append(r12)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r15.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r15.element
            return r1
        L_0x0156:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r11)
            r6.append(r12)
            java.lang.String r11 = " gave failed result\n"
            r6.append(r11)
            T r11 = r15.element
            r6.append(r11)
            java.lang.String r11 = " for call, \nwith details:"
            r6.append(r11)
            java.lang.String r6 = r6.toString()
            r12 = 0
            java.lang.Object[] r11 = new java.lang.Object[r12]
            r1.w(r6, r11)
            r1 = r10
            r11 = r15
            goto L_0x00d7
        L_0x017d:
            T r1 = r11.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r8.logApiError(r1)
            T r1 = r11.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setOscillationParams(int, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setMainMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setMainMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setMainMode$1 r2 = (com.blueair.api.ConnectionManager$setMainMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setMainMode$1 r2 = new com.blueair.api.ConnectionManager$setMainMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setMainMode$2 r1 = com.blueair.api.ConnectionManager$setMainMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMainMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setMainMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setApSubMode(int r18, boolean r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setApSubMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setApSubMode$1 r2 = (com.blueair.api.ConnectionManager$setApSubMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setApSubMode$1 r2 = new com.blueair.api.ConnectionManager$setApSubMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 != r5) goto L_0x0061
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            boolean r8 = r2.Z$0
            int r9 = r2.I$0
            java.lang.Object r10 = r2.L$7
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$6
            com.blueair.api.client.CanSetMainMode r11 = (com.blueair.api.client.CanSetMainMode) r11
            java.lang.Object r11 = r2.L$5
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Object r12 = r2.L$3
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$0
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r8
            r8 = r7
            r7 = r16
            goto L_0x0119
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetMainMode> r9 = com.blueair.api.client.CanSetMainMode.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00ae:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c0
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetMainMode
            if (r9 == 0) goto L_0x00ae
            r7.add(r8)
            goto L_0x00ae
        L_0x00c0:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r15 = r0
            r10 = r1
            r12 = r4
            r8 = r6
            r13 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00d3:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x0175
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r11
            com.blueair.api.client.CanSetMainMode r14 = (com.blueair.api.client.CanSetMainMode) r14
            r4.L$0 = r15
            r4.L$1 = r10
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$2 = r5
            r4.L$3 = r12
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$4 = r5
            r4.L$5 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r4.L$6 = r5
            r4.L$7 = r10
            r4.I$0 = r1
            r4.Z$0 = r2
            r4.I$1 = r8
            r4.I$2 = r7
            r4.I$3 = r6
            r4.I$4 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r9 = r14.setApSubMode(r1, r2, r4)
            if (r9 != r3) goto L_0x0115
            return r3
        L_0x0115:
            r14 = r9
            r9 = r1
            r1 = r14
            r14 = r10
        L_0x0119:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x014e
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r14.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r14.element
            return r1
        L_0x014e:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r14.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r9
            r10 = r14
            r5 = 1
            goto L_0x00d3
        L_0x0175:
            T r1 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r10.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setApSubMode(int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setApFanSpeed(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setApFanSpeed$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setApFanSpeed$1 r2 = (com.blueair.api.ConnectionManager$setApFanSpeed$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setApFanSpeed$1 r2 = new com.blueair.api.ConnectionManager$setApFanSpeed$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setApFanSpeed$2 r1 = com.blueair.api.ConnectionManager$setApFanSpeed$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMainMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setApFanSpeed(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHeatSubMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHeatSubMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHeatSubMode$1 r2 = (com.blueair.api.ConnectionManager$setHeatSubMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHeatSubMode$1 r2 = new com.blueair.api.ConnectionManager$setHeatSubMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHeatSubMode$2 r1 = com.blueair.api.ConnectionManager$setHeatSubMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMainMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHeatSubMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHeatFanSpeed(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHeatFanSpeed$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHeatFanSpeed$1 r2 = (com.blueair.api.ConnectionManager$setHeatFanSpeed$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHeatFanSpeed$1 r2 = new com.blueair.api.ConnectionManager$setHeatFanSpeed$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHeatFanSpeed$2 r1 = com.blueair.api.ConnectionManager$setHeatFanSpeed$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMainMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHeatFanSpeed(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHeatAutoTmp(double r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHeatAutoTmp$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHeatAutoTmp$1 r2 = (com.blueair.api.ConnectionManager$setHeatAutoTmp$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHeatAutoTmp$1 r2 = new com.blueair.api.ConnectionManager$setHeatAutoTmp$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0068
            if (r4 != r5) goto L_0x0060
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            double r8 = r2.D$0
            java.lang.Object r10 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$7
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$6
            java.lang.Object r12 = r2.L$5
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$4
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$2
            java.lang.Double r15 = (java.lang.Double) r15
            java.lang.Object r5 = r2.L$1
            kotlin.reflect.KFunction r5 = (kotlin.reflect.KFunction) r5
            java.lang.Object r6 = r2.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r0 = r4
            r4 = r2
            r2 = r7
            r7 = r6
            r6 = r5
            r5 = r0
            r0 = 1
            goto L_0x015c
        L_0x0060:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHeatAutoTmp$2 r1 = com.blueair.api.ConnectionManager$setHeatAutoTmp$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Double r4 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r19)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r7 = ", with "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = " on "
            r6.append(r7)
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r7 = " clients"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.d(r6, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r6.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.v(r6, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " could call "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.<init>(r7)
            r5.element = r6
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r0.clients
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x00f3:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0105
            java.lang.Object r8 = r6.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetMainMode
            if (r9 == 0) goto L_0x00f3
            r7.add(r8)
            goto L_0x00f3
        L_0x0105:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r6 = r7.iterator()
            r15 = r4
            r10 = r5
            r12 = r6
            r13 = r7
            r5 = 0
            r8 = 0
            r7 = r0
            r6 = r1
            r4 = r2
            r1 = r19
        L_0x0118:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x01c8
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r6
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r4.L$0 = r7
            r4.L$1 = r6
            r4.L$2 = r15
            r4.L$3 = r10
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$4 = r0
            r4.L$5 = r12
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$6 = r0
            r4.L$7 = r11
            r4.L$8 = r10
            r4.D$0 = r1
            r4.I$0 = r8
            r4.I$1 = r5
            r0 = 0
            r4.I$2 = r0
            r0 = 1
            r4.label = r0
            java.lang.Object r9 = r14.invoke(r11, r15, r4)
            if (r9 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r14 = r10
            r16 = r1
            r2 = r8
            r1 = r9
            r8 = r16
        L_0x015c:
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x0193
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r11)
            java.lang.String r2 = " gave good result "
            r1.append(r2)
            T r2 = r14.element
            r1.append(r2)
            java.lang.String r2 = " for call "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r7 = 0
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r0.v(r1, r2)
            T r0 = r14.element
            return r0
        L_0x0193:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            r0.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r0.append(r10)
            T r10 = r14.element
            r0.append(r10)
            java.lang.String r10 = " for call \n"
            r0.append(r10)
            r0.append(r6)
            java.lang.String r10 = ", \nwith details:"
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r11 = 0
            java.lang.Object[] r10 = new java.lang.Object[r11]
            r1.w(r0, r10)
            r16 = r8
            r8 = r2
            r1 = r16
            r0 = r18
            r10 = r14
            goto L_0x0118
        L_0x01c8:
            T r0 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Throwable r0 = r0.exceptionOrNull()
            r7.logApiError(r0)
            T r0 = r10.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHeatAutoTmp(double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHeatEcoTmp(double r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r21) {
        /*
            r18 = this;
            r0 = r18
            r1 = r21
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHeatEcoTmp$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHeatEcoTmp$1 r2 = (com.blueair.api.ConnectionManager$setHeatEcoTmp$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHeatEcoTmp$1 r2 = new com.blueair.api.ConnectionManager$setHeatEcoTmp$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L_0x0068
            if (r4 != r5) goto L_0x0060
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            double r8 = r2.D$0
            java.lang.Object r10 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$7
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$6
            java.lang.Object r12 = r2.L$5
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$4
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$2
            java.lang.Double r15 = (java.lang.Double) r15
            java.lang.Object r5 = r2.L$1
            kotlin.reflect.KFunction r5 = (kotlin.reflect.KFunction) r5
            java.lang.Object r6 = r2.L$0
            com.blueair.api.ConnectionManager r6 = (com.blueair.api.ConnectionManager) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r0 = r4
            r4 = r2
            r2 = r7
            r7 = r6
            r6 = r5
            r5 = r0
            r0 = 1
            goto L_0x015c
        L_0x0060:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0068:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHeatEcoTmp$2 r1 = com.blueair.api.ConnectionManager$setHeatEcoTmp$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Double r4 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r19)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r7 = ", with "
            r6.append(r7)
            r6.append(r4)
            java.lang.String r7 = " on "
            r6.append(r7)
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r7 = " clients"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r7 = 0
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.d(r6, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r6.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r8 = new java.lang.Object[r7]
            r5.v(r6, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r6 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " could call "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.<init>(r7)
            r5.element = r6
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r0.clients
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r6 = r6.iterator()
        L_0x00f3:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0105
            java.lang.Object r8 = r6.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetMainMode
            if (r9 == 0) goto L_0x00f3
            r7.add(r8)
            goto L_0x00f3
        L_0x0105:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r6 = r7.iterator()
            r15 = r4
            r10 = r5
            r12 = r6
            r13 = r7
            r5 = 0
            r8 = 0
            r7 = r0
            r6 = r1
            r4 = r2
            r1 = r19
        L_0x0118:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x01c8
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r6
            kotlin.jvm.functions.Function3 r14 = (kotlin.jvm.functions.Function3) r14
            r4.L$0 = r7
            r4.L$1 = r6
            r4.L$2 = r15
            r4.L$3 = r10
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$4 = r0
            r4.L$5 = r12
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$6 = r0
            r4.L$7 = r11
            r4.L$8 = r10
            r4.D$0 = r1
            r4.I$0 = r8
            r4.I$1 = r5
            r0 = 0
            r4.I$2 = r0
            r0 = 1
            r4.label = r0
            java.lang.Object r9 = r14.invoke(r11, r15, r4)
            if (r9 != r3) goto L_0x0155
            return r3
        L_0x0155:
            r14 = r10
            r16 = r1
            r2 = r8
            r1 = r9
            r8 = r16
        L_0x015c:
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x0193
            timber.log.Timber$Forest r0 = timber.log.Timber.Forest
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r10)
            r1.append(r11)
            java.lang.String r2 = " gave good result "
            r1.append(r2)
            T r2 = r14.element
            r1.append(r2)
            java.lang.String r2 = " for call "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r7 = 0
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r0.v(r1, r2)
            T r0 = r14.element
            return r0
        L_0x0193:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r10)
            r0.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r0.append(r10)
            T r10 = r14.element
            r0.append(r10)
            java.lang.String r10 = " for call \n"
            r0.append(r10)
            r0.append(r6)
            java.lang.String r10 = ", \nwith details:"
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            r11 = 0
            java.lang.Object[] r10 = new java.lang.Object[r11]
            r1.w(r0, r10)
            r16 = r8
            r8 = r2
            r1 = r16
            r0 = r18
            r10 = r14
            goto L_0x0118
        L_0x01c8:
            T r0 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r0 = (io.flatcircle.coroutinehelper.ApiResult) r0
            java.lang.Throwable r0 = r0.exceptionOrNull()
            r7.logApiError(r0)
            T r0 = r10.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHeatEcoTmp(double, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setCoolSubMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setCoolSubMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setCoolSubMode$1 r2 = (com.blueair.api.ConnectionManager$setCoolSubMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setCoolSubMode$1 r2 = new com.blueair.api.ConnectionManager$setCoolSubMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setCoolSubMode$2 r1 = com.blueair.api.ConnectionManager$setCoolSubMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMainMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setCoolSubMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setCoolFanSpeed(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setCoolFanSpeed$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setCoolFanSpeed$1 r2 = (com.blueair.api.ConnectionManager$setCoolFanSpeed$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setCoolFanSpeed$1 r2 = new com.blueair.api.ConnectionManager$setCoolFanSpeed$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setCoolFanSpeed$2 r1 = com.blueair.api.ConnectionManager$setCoolFanSpeed$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMainMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setCoolFanSpeed(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setCoolAutoPresets(int r18, double[] r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setCoolAutoPresets$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setCoolAutoPresets$1 r2 = (com.blueair.api.ConnectionManager$setCoolAutoPresets$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setCoolAutoPresets$1 r2 = new com.blueair.api.ConnectionManager$setCoolAutoPresets$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0070
            if (r4 != r5) goto L_0x0068
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.CanSetMainMode r10 = (com.blueair.api.client.CanSetMainMode) r10
            java.lang.Object r10 = r2.L$6
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Object r11 = r2.L$4
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$3
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$1
            com.blueair.api.ConnectionManager r14 = (com.blueair.api.ConnectionManager) r14
            java.lang.Object r15 = r2.L$0
            double[] r15 = (double[]) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r15
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r7
            r7 = r16
            goto L_0x0125
        L_0x0068:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetMainMode> r9 = com.blueair.api.client.CanSetMainMode.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00b5:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c7
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetMainMode
            if (r9 == 0) goto L_0x00b5
            r7.add(r8)
            goto L_0x00b5
        L_0x00c7:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r14 = r0
            r9 = r1
            r11 = r4
            r8 = r6
            r12 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00da:
            boolean r10 = r11.hasNext()
            if (r10 == 0) goto L_0x0185
            java.lang.Object r10 = r11.next()
            r13 = r10
            com.blueair.api.client.DeviceClient r13 = (com.blueair.api.client.DeviceClient) r13
            r15 = r13
            com.blueair.api.client.CanSetMainMode r15 = (com.blueair.api.client.CanSetMainMode) r15
            r4.L$0 = r2
            r4.L$1 = r14
            r4.L$2 = r9
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r4.L$3 = r5
            r4.L$4 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$5 = r5
            r4.L$6 = r13
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r4.L$7 = r5
            r4.L$8 = r9
            r4.I$0 = r1
            r4.I$1 = r8
            r4.I$2 = r7
            r4.I$3 = r6
            r4.I$4 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r10 = r15.setCoolAutoPresets(r1, r2, r4)
            if (r10 != r3) goto L_0x011c
            return r3
        L_0x011c:
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r13
            r13 = r9
            r9 = r8
            r8 = r1
            r1 = r10
            r10 = r13
        L_0x0125:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x015a
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x015a:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r13.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r8
            r8 = r9
            r11 = r12
            r9 = r13
            r12 = r14
            r14 = r15
            r5 = 1
            goto L_0x00da
        L_0x0185:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r14.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setCoolAutoPresets(int, double[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setCoolEcoPresets(int r18, double[] r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setCoolEcoPresets$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setCoolEcoPresets$1 r2 = (com.blueair.api.ConnectionManager$setCoolEcoPresets$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setCoolEcoPresets$1 r2 = new com.blueair.api.ConnectionManager$setCoolEcoPresets$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0070
            if (r4 != r5) goto L_0x0068
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.CanSetMainMode r10 = (com.blueair.api.client.CanSetMainMode) r10
            java.lang.Object r10 = r2.L$6
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Object r11 = r2.L$4
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$3
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$1
            com.blueair.api.ConnectionManager r14 = (com.blueair.api.ConnectionManager) r14
            java.lang.Object r15 = r2.L$0
            double[] r15 = (double[]) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r15
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r7
            r7 = r16
            goto L_0x0125
        L_0x0068:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetMainMode> r9 = com.blueair.api.client.CanSetMainMode.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00b5:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c7
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetMainMode
            if (r9 == 0) goto L_0x00b5
            r7.add(r8)
            goto L_0x00b5
        L_0x00c7:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r14 = r0
            r9 = r1
            r11 = r4
            r8 = r6
            r12 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00da:
            boolean r10 = r11.hasNext()
            if (r10 == 0) goto L_0x0185
            java.lang.Object r10 = r11.next()
            r13 = r10
            com.blueair.api.client.DeviceClient r13 = (com.blueair.api.client.DeviceClient) r13
            r15 = r13
            com.blueair.api.client.CanSetMainMode r15 = (com.blueair.api.client.CanSetMainMode) r15
            r4.L$0 = r2
            r4.L$1 = r14
            r4.L$2 = r9
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r4.L$3 = r5
            r4.L$4 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$5 = r5
            r4.L$6 = r13
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r4.L$7 = r5
            r4.L$8 = r9
            r4.I$0 = r1
            r4.I$1 = r8
            r4.I$2 = r7
            r4.I$3 = r6
            r4.I$4 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r10 = r15.setCoolEcoPresets(r1, r2, r4)
            if (r10 != r3) goto L_0x011c
            return r3
        L_0x011c:
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r13
            r13 = r9
            r9 = r8
            r8 = r1
            r1 = r10
            r10 = r13
        L_0x0125:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x015a
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x015a:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r13.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r8
            r8 = r9
            r11 = r12
            r9 = r13
            r12 = r14
            r14 = r15
            r5 = 1
            goto L_0x00da
        L_0x0185:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r14.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setCoolEcoPresets(int, double[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setMode$1 r2 = (com.blueair.api.ConnectionManager$setMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setMode$1 r2 = new com.blueair.api.ConnectionManager$setMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setMode$2 r1 = com.blueair.api.ConnectionManager$setMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHumMode(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHumMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHumMode$1 r2 = (com.blueair.api.ConnectionManager$setHumMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHumMode$1 r2 = new com.blueair.api.ConnectionManager$setHumMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHumMode$2 r1 = com.blueair.api.ConnectionManager$setHumMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetHumMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHumMode(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setDehSubMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setDehSubMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setDehSubMode$1 r2 = (com.blueair.api.ConnectionManager$setDehSubMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setDehSubMode$1 r2 = new com.blueair.api.ConnectionManager$setDehSubMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setDehSubMode$2 r1 = com.blueair.api.ConnectionManager$setDehSubMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetDehSubMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setDehSubMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setSmartSubMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setSmartSubMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setSmartSubMode$1 r2 = (com.blueair.api.ConnectionManager$setSmartSubMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setSmartSubMode$1 r2 = new com.blueair.api.ConnectionManager$setSmartSubMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setSmartSubMode$2 r1 = com.blueair.api.ConnectionManager$setSmartSubMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetSmartSubMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setSmartSubMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setTare(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$setTare$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$setTare$1 r0 = (com.blueair.api.ConnectionManager$setTare$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$setTare$1 r0 = new com.blueair.api.ConnectionManager$setTare$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$setTare$2 r15 = com.blueair.api.ConnectionManager$setTare$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanSetTare
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setTare(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setPanelDisplayMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setPanelDisplayMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setPanelDisplayMode$1 r2 = (com.blueair.api.ConnectionManager$setPanelDisplayMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setPanelDisplayMode$1 r2 = new com.blueair.api.ConnectionManager$setPanelDisplayMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setPanelDisplayMode$2 r1 = com.blueair.api.ConnectionManager$setPanelDisplayMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetPanelDisplayMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setPanelDisplayMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHoverEnabled(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHoverEnabled$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHoverEnabled$1 r2 = (com.blueair.api.ConnectionManager$setHoverEnabled$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHoverEnabled$1 r2 = new com.blueair.api.ConnectionManager$setHoverEnabled$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setHoverEnabled$2 r1 = com.blueair.api.ConnectionManager$setHoverEnabled$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetHoverEnabled
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHoverEnabled(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setAirRefreshStatus(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setAirRefreshStatus$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setAirRefreshStatus$1 r2 = (com.blueair.api.ConnectionManager$setAirRefreshStatus$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setAirRefreshStatus$1 r2 = new com.blueair.api.ConnectionManager$setAirRefreshStatus$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setAirRefreshStatus$2 r1 = com.blueair.api.ConnectionManager$setAirRefreshStatus$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetAirRefresh
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setAirRefreshStatus(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setAirRefreshEnabled(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setAirRefreshEnabled$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setAirRefreshEnabled$1 r2 = (com.blueair.api.ConnectionManager$setAirRefreshEnabled$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setAirRefreshEnabled$1 r2 = new com.blueair.api.ConnectionManager$setAirRefreshEnabled$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setAirRefreshEnabled$2 r1 = com.blueair.api.ConnectionManager$setAirRefreshEnabled$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetAirRefresh
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setAirRefreshEnabled(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setNightLampBrightness(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setNightLampBrightness$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setNightLampBrightness$1 r2 = (com.blueair.api.ConnectionManager$setNightLampBrightness$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setNightLampBrightness$1 r2 = new com.blueair.api.ConnectionManager$setNightLampBrightness$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setNightLampBrightness$2 r1 = com.blueair.api.ConnectionManager$setNightLampBrightness$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetNightLamp
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setNightLampBrightness(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setNightLampSteplessBrightness(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$1 r2 = (com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$1 r2 = new com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$2 r1 = com.blueair.api.ConnectionManager$setNightLampSteplessBrightness$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetNightLamp
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setNightLampSteplessBrightness(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setYwrmEnabled(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setYwrmEnabled$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setYwrmEnabled$1 r2 = (com.blueair.api.ConnectionManager$setYwrmEnabled$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setYwrmEnabled$1 r2 = new com.blueair.api.ConnectionManager$setYwrmEnabled$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setYwrmEnabled$2 r1 = com.blueair.api.ConnectionManager$setYwrmEnabled$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetYellowWaterRemove
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setYwrmEnabled(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setAlarm(int r18, com.blueair.core.model.DeviceAlarm r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setAlarm$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setAlarm$1 r2 = (com.blueair.api.ConnectionManager$setAlarm$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setAlarm$1 r2 = new com.blueair.api.ConnectionManager$setAlarm$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0070
            if (r4 != r5) goto L_0x0068
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.CanSetAlarm r10 = (com.blueair.api.client.CanSetAlarm) r10
            java.lang.Object r10 = r2.L$6
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Object r11 = r2.L$4
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$3
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$2
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$1
            com.blueair.api.ConnectionManager r14 = (com.blueair.api.ConnectionManager) r14
            java.lang.Object r15 = r2.L$0
            com.blueair.core.model.DeviceAlarm r15 = (com.blueair.core.model.DeviceAlarm) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r15
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r7
            r7 = r16
            goto L_0x0125
        L_0x0068:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetAlarm> r9 = com.blueair.api.client.CanSetAlarm.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00b5:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c7
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetAlarm
            if (r9 == 0) goto L_0x00b5
            r7.add(r8)
            goto L_0x00b5
        L_0x00c7:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r14 = r0
            r9 = r1
            r11 = r4
            r8 = r6
            r12 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00da:
            boolean r10 = r11.hasNext()
            if (r10 == 0) goto L_0x0185
            java.lang.Object r10 = r11.next()
            r13 = r10
            com.blueair.api.client.DeviceClient r13 = (com.blueair.api.client.DeviceClient) r13
            r15 = r13
            com.blueair.api.client.CanSetAlarm r15 = (com.blueair.api.client.CanSetAlarm) r15
            r4.L$0 = r2
            r4.L$1 = r14
            r4.L$2 = r9
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r4.L$3 = r5
            r4.L$4 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$5 = r5
            r4.L$6 = r13
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r4.L$7 = r5
            r4.L$8 = r9
            r4.I$0 = r1
            r4.I$1 = r8
            r4.I$2 = r7
            r4.I$3 = r6
            r4.I$4 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r10 = r15.setAlarm(r1, r2, r4)
            if (r10 != r3) goto L_0x011c
            return r3
        L_0x011c:
            r15 = r14
            r14 = r12
            r12 = r11
            r11 = r13
            r13 = r9
            r9 = r8
            r8 = r1
            r1 = r10
            r10 = r13
        L_0x0125:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x015a
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x015a:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r13.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r8
            r8 = r9
            r11 = r12
            r9 = r13
            r12 = r14
            r14 = r15
            r5 = 1
            goto L_0x00da
        L_0x0185:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r14.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setAlarm(int, com.blueair.core.model.DeviceAlarm, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object playAlarm(int r18, int r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$playAlarm$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$playAlarm$1 r2 = (com.blueair.api.ConnectionManager$playAlarm$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$playAlarm$1 r2 = new com.blueair.api.ConnectionManager$playAlarm$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 != r5) goto L_0x0061
            int r4 = r2.I$5
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r7 = r2.I$2
            int r8 = r2.I$1
            int r9 = r2.I$0
            java.lang.Object r10 = r2.L$7
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$6
            com.blueair.api.client.CanSetAlarm r11 = (com.blueair.api.client.CanSetAlarm) r11
            java.lang.Object r11 = r2.L$5
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Object r12 = r2.L$3
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$0
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r8
            r8 = r7
            r7 = r16
            goto L_0x0119
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetAlarm> r9 = com.blueair.api.client.CanSetAlarm.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00ae:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c0
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetAlarm
            if (r9 == 0) goto L_0x00ae
            r7.add(r8)
            goto L_0x00ae
        L_0x00c0:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r15 = r0
            r10 = r1
            r12 = r4
            r8 = r6
            r13 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00d3:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x0175
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r11
            com.blueair.api.client.CanSetAlarm r14 = (com.blueair.api.client.CanSetAlarm) r14
            r4.L$0 = r15
            r4.L$1 = r10
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$2 = r5
            r4.L$3 = r12
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$4 = r5
            r4.L$5 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r4.L$6 = r5
            r4.L$7 = r10
            r4.I$0 = r1
            r4.I$1 = r2
            r4.I$2 = r8
            r4.I$3 = r7
            r4.I$4 = r6
            r4.I$5 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r9 = r14.playAlarm(r1, r2, r4)
            if (r9 != r3) goto L_0x0115
            return r3
        L_0x0115:
            r14 = r9
            r9 = r1
            r1 = r14
            r14 = r10
        L_0x0119:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x014e
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r14.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r14.element
            return r1
        L_0x014e:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r14.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r9
            r10 = r14
            r5 = 1
            goto L_0x00d3
        L_0x0175:
            T r1 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r10.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.playAlarm(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object stopAlarm(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$stopAlarm$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$stopAlarm$1 r0 = (com.blueair.api.ConnectionManager$stopAlarm$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$stopAlarm$1 r0 = new com.blueair.api.ConnectionManager$stopAlarm$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$stopAlarm$2 r15 = com.blueair.api.ConnectionManager$stopAlarm$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanSetAlarm
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.stopAlarm(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object setHumSubMode$default(ConnectionManager connectionManager, int i, boolean z, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return connectionManager.setHumSubMode(i, z, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setHumSubMode(int r18, boolean r19, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setHumSubMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setHumSubMode$1 r2 = (com.blueair.api.ConnectionManager$setHumSubMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setHumSubMode$1 r2 = new com.blueair.api.ConnectionManager$setHumSubMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0069
            if (r4 != r5) goto L_0x0061
            int r4 = r2.I$4
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            boolean r8 = r2.Z$0
            int r9 = r2.I$0
            java.lang.Object r10 = r2.L$7
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r2.L$6
            com.blueair.api.client.CanSetHumSubMode r11 = (com.blueair.api.client.CanSetHumSubMode) r11
            java.lang.Object r11 = r2.L$5
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Object r12 = r2.L$3
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r13 = r2.L$2
            java.lang.Iterable r13 = (java.lang.Iterable) r13
            java.lang.Object r14 = r2.L$1
            kotlin.jvm.internal.Ref$ObjectRef r14 = (kotlin.jvm.internal.Ref.ObjectRef) r14
            java.lang.Object r15 = r2.L$0
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            kotlin.ResultKt.throwOnFailure(r1)
            r16 = r4
            r4 = r2
            r2 = r8
            r8 = r7
            r7 = r16
            goto L_0x0119
        L_0x0061:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0069:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            io.flatcircle.coroutinehelper.Failure r4 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r7 = new java.lang.UnknownError
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "None of the clients in "
            r8.<init>(r9)
            r8.append(r0)
            java.lang.String r9 = " is "
            r8.append(r9)
            java.lang.Class<com.blueair.api.client.CanSetHumSubMode> r9 = com.blueair.api.client.CanSetHumSubMode.class
            kotlin.reflect.KClass r9 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r9)
            java.lang.String r9 = r9.getQualifiedName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r4.<init>(r7)
            r1.element = r4
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00ae:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00c0
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanSetHumSubMode
            if (r9 == 0) goto L_0x00ae
            r7.add(r8)
            goto L_0x00ae
        L_0x00c0:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r15 = r0
            r10 = r1
            r12 = r4
            r8 = r6
            r13 = r7
            r1 = r18
            r4 = r2
            r7 = r8
            r2 = r19
        L_0x00d3:
            boolean r9 = r12.hasNext()
            if (r9 == 0) goto L_0x0175
            java.lang.Object r9 = r12.next()
            r11 = r9
            com.blueair.api.client.DeviceClient r11 = (com.blueair.api.client.DeviceClient) r11
            r14 = r11
            com.blueair.api.client.CanSetHumSubMode r14 = (com.blueair.api.client.CanSetHumSubMode) r14
            r4.L$0 = r15
            r4.L$1 = r10
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$2 = r5
            r4.L$3 = r12
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r4.L$4 = r5
            r4.L$5 = r11
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r4.L$6 = r5
            r4.L$7 = r10
            r4.I$0 = r1
            r4.Z$0 = r2
            r4.I$1 = r8
            r4.I$2 = r7
            r4.I$3 = r6
            r4.I$4 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r9 = r14.setHumSubMode(r1, r2, r4)
            if (r9 != r3) goto L_0x0115
            return r3
        L_0x0115:
            r14 = r9
            r9 = r1
            r1 = r14
            r14 = r10
        L_0x0119:
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            r10.element = r1
            T r1 = r14.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r10 = "client "
            if (r1 == 0) goto L_0x014e
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r10)
            r2.append(r11)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r14.element
            r2.append(r3)
            java.lang.String r3 = " for call"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r14.element
            return r1
        L_0x014e:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r10)
            r5.append(r11)
            java.lang.String r10 = " gave failed result\n"
            r5.append(r10)
            T r10 = r14.element
            r5.append(r10)
            java.lang.String r10 = " for call, \nwith details:"
            r5.append(r10)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            r1.w(r5, r10)
            r1 = r9
            r10 = r14
            r5 = 1
            goto L_0x00d3
        L_0x0175:
            T r1 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r10.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setHumSubMode(int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setUse24Hour(boolean r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setUse24Hour$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setUse24Hour$1 r2 = (com.blueair.api.ConnectionManager$setUse24Hour$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setUse24Hour$1 r2 = new com.blueair.api.ConnectionManager$setUse24Hour$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            boolean r8 = r2.Z$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setUse24Hour$2 r1 = com.blueair.api.ConnectionManager$setUse24Hour$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetHourFormat
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.Z$0 = r1
            r2.I$0 = r7
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setUse24Hour(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteLinkedUid(java.lang.String r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$deleteLinkedUid$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$deleteLinkedUid$1 r2 = (com.blueair.api.ConnectionManager$deleteLinkedUid$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$deleteLinkedUid$1 r2 = new com.blueair.api.ConnectionManager$deleteLinkedUid$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$deleteLinkedUid$2 r1 = com.blueair.api.ConnectionManager$deleteLinkedUid$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanLinkWithAware
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.deleteLinkedUid(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createSchedule(com.blueair.core.model.DeviceSchedule r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<okhttp3.ResponseBody>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$createSchedule$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$createSchedule$1 r2 = (com.blueair.api.ConnectionManager$createSchedule$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$createSchedule$1 r2 = new com.blueair.api.ConnectionManager$createSchedule$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            com.blueair.core.model.DeviceSchedule r13 = (com.blueair.core.model.DeviceSchedule) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$createSchedule$2 r1 = com.blueair.api.ConnectionManager$createSchedule$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanManageSchedule
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.createSchedule(com.blueair.core.model.DeviceSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateSchedule(com.blueair.core.model.DeviceSchedule r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$updateSchedule$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$updateSchedule$1 r2 = (com.blueair.api.ConnectionManager$updateSchedule$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$updateSchedule$1 r2 = new com.blueair.api.ConnectionManager$updateSchedule$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            com.blueair.core.model.DeviceSchedule r13 = (com.blueair.core.model.DeviceSchedule) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.core.model.DeviceSchedule r5 = (com.blueair.core.model.DeviceSchedule) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$updateSchedule$2 r1 = com.blueair.api.ConnectionManager$updateSchedule$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanManageSchedule
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.updateSchedule(com.blueair.core.model.DeviceSchedule, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getSchedules(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.util.List<com.blueair.core.model.DeviceSchedule>>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getSchedules$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getSchedules$1 r0 = (com.blueair.api.ConnectionManager$getSchedules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getSchedules$1 r0 = new com.blueair.api.ConnectionManager$getSchedules$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getSchedules$2 r15 = com.blueair.api.ConnectionManager$getSchedules$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanManageSchedule
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getSchedules(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteSchedule(java.lang.String r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$deleteSchedule$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$deleteSchedule$1 r2 = (com.blueair.api.ConnectionManager$deleteSchedule$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$deleteSchedule$1 r2 = new com.blueair.api.ConnectionManager$deleteSchedule$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$7
            com.blueair.api.client.DeviceClient r8 = (com.blueair.api.client.DeviceClient) r8
            java.lang.Object r8 = r2.L$6
            java.lang.Object r8 = r2.L$5
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r2.L$4
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r2.L$3
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$2
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r2.L$1
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            java.lang.Object r13 = r2.L$0
            java.lang.String r13 = (java.lang.String) r13
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r10
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r4
            r4 = r2
            r2 = r13
            goto L_0x00dc
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$deleteSchedule$2 r1 = com.blueair.api.ConnectionManager$deleteSchedule$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r7, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r7, r8)
            java.util.List<com.blueair.api.client.DeviceClient> r4 = r0.clients
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r4 = r4.iterator()
        L_0x00b8:
            boolean r8 = r4.hasNext()
            if (r8 == 0) goto L_0x00ca
            java.lang.Object r8 = r4.next()
            boolean r9 = r8 instanceof com.blueair.api.client.CanManageSchedule
            if (r9 == 0) goto L_0x00b8
            r7.add(r8)
            goto L_0x00b8
        L_0x00ca:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r4 = r7.iterator()
            r12 = r0
            r11 = r1
            r9 = r4
            r8 = r6
            r10 = r7
            r1 = r17
            r4 = r2
            r7 = r8
            r2 = r1
        L_0x00dc:
            boolean r13 = r9.hasNext()
            if (r13 == 0) goto L_0x0120
            java.lang.Object r13 = r9.next()
            r14 = r13
            com.blueair.api.client.DeviceClient r14 = (com.blueair.api.client.DeviceClient) r14
            r15 = r11
            kotlin.jvm.functions.Function3 r15 = (kotlin.jvm.functions.Function3) r15
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r4.L$0 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r4.L$1 = r5
            r4.L$2 = r11
            r4.L$3 = r1
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r10)
            r4.L$4 = r5
            r4.L$5 = r9
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r4.L$6 = r5
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r14)
            r4.L$7 = r5
            r4.I$0 = r8
            r4.I$1 = r7
            r4.I$2 = r6
            r5 = 1
            r4.label = r5
            java.lang.Object r13 = r15.invoke(r14, r1, r4)
            if (r13 != r3) goto L_0x00dc
            return r3
        L_0x0120:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.String r2 = "Failing here?"
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.d(r2, r3)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.deleteSchedule(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setSensorMode(int r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setSensorMode$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setSensorMode$1 r2 = (com.blueair.api.ConnectionManager$setSensorMode$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setSensorMode$1 r2 = new com.blueair.api.ConnectionManager$setSensorMode$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0063
            if (r4 != r5) goto L_0x005b
            int r4 = r2.I$3
            int r4 = r2.I$2
            int r7 = r2.I$1
            int r8 = r2.I$0
            java.lang.Object r9 = r2.L$8
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$7
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            java.lang.Object r11 = r2.L$6
            java.lang.Object r11 = r2.L$5
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r2.L$4
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.lang.Object r13 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r13 = (kotlin.jvm.internal.Ref.ObjectRef) r13
            java.lang.Object r14 = r2.L$2
            java.lang.Integer r14 = (java.lang.Integer) r14
            java.lang.Object r15 = r2.L$1
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.api.ConnectionManager r5 = (com.blueair.api.ConnectionManager) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0152
        L_0x005b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0063:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setSensorMode$2 r1 = com.blueair.api.ConnectionManager$setSensorMode$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r17)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Attempting to doApiCall "
            r7.<init>(r8)
            r7.append(r1)
            java.lang.String r8 = ", with "
            r7.append(r8)
            r7.append(r4)
            java.lang.String r8 = " on "
            r7.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r7.append(r8)
            java.lang.String r8 = " clients"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.d(r7, r8)
            timber.log.Timber$Forest r5 = timber.log.Timber.Forest
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r7.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r5.v(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            io.flatcircle.coroutinehelper.Failure r7 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r7.<init>(r8)
            r5.element = r7
            java.util.List<com.blueair.api.client.DeviceClient> r7 = r0.clients
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00ed:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r7.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetSensorMode
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r7 = r8.iterator()
            r15 = r1
            r14 = r4
            r9 = r5
            r4 = r6
            r11 = r7
            r12 = r8
            r1 = r17
            r5 = r0
            r7 = r4
        L_0x0111:
            boolean r8 = r11.hasNext()
            if (r8 == 0) goto L_0x01b9
            java.lang.Object r8 = r11.next()
            r10 = r8
            com.blueair.api.client.DeviceClient r10 = (com.blueair.api.client.DeviceClient) r10
            r13 = r15
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            r2.L$0 = r5
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r9
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r12)
            r2.L$4 = r6
            r2.L$5 = r11
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r2.L$6 = r6
            r2.L$7 = r10
            r2.L$8 = r9
            r2.I$0 = r1
            r2.I$1 = r7
            r2.I$2 = r4
            r6 = 0
            r2.I$3 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r8 = r13.invoke(r10, r14, r2)
            if (r8 != r3) goto L_0x014e
            return r3
        L_0x014e:
            r13 = r8
            r8 = r1
            r1 = r13
            r13 = r9
        L_0x0152:
            r9.element = r1
            T r1 = r13.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r9 = "client "
            if (r1 == 0) goto L_0x0189
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            r2.append(r10)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r13.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r15)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r13.element
            return r1
        L_0x0189:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r9)
            r6.append(r10)
            java.lang.String r9 = " gave failed result\n"
            r6.append(r9)
            T r9 = r13.element
            r6.append(r9)
            java.lang.String r9 = " for call \n"
            r6.append(r9)
            r6.append(r15)
            java.lang.String r9 = ", \nwith details:"
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r10 = 0
            java.lang.Object[] r9 = new java.lang.Object[r10]
            r1.w(r6, r9)
            r1 = r8
            r6 = r10
            r9 = r13
            goto L_0x0111
        L_0x01b9:
            T r1 = r9.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r5.logApiError(r1)
            T r1 = r9.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setSensorMode(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void clear() {
        synchronized (this.clientLock) {
            for (DeviceClient clear : this.clients) {
                clear.clear();
            }
            this.clients.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setDeviceName(java.lang.String r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.Object>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setDeviceName$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setDeviceName$1 r2 = (com.blueair.api.ConnectionManager$setDeviceName$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setDeviceName$1 r2 = new com.blueair.api.ConnectionManager$setDeviceName$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setDeviceName$2 r1 = com.blueair.api.ConnectionManager$setDeviceName$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetDeviceName
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setDeviceName(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object setFilterType(java.lang.String r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<com.blueair.api.restapi.SimpleResponse>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$setFilterType$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$setFilterType$1 r2 = (com.blueair.api.ConnectionManager$setFilterType$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$setFilterType$1 r2 = new com.blueair.api.ConnectionManager$setFilterType$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$setFilterType$2 r1 = com.blueair.api.ConnectionManager$setFilterType$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanSetFilterType
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.setFilterType(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getDeviceStatus(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<java.lang.String>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$getDeviceStatus$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$getDeviceStatus$1 r0 = (com.blueair.api.ConnectionManager$getDeviceStatus$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$getDeviceStatus$1 r0 = new com.blueair.api.ConnectionManager$getDeviceStatus$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$getDeviceStatus$2 r15 = com.blueair.api.ConnectionManager$getDeviceStatus$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanGetStatus
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.getDeviceStatus(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createWelcomeHome(com.blueair.core.model.WelcomeHomeLocation r17, kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<kotlin.Unit>> r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.blueair.api.ConnectionManager$createWelcomeHome$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.blueair.api.ConnectionManager$createWelcomeHome$1 r2 = (com.blueair.api.ConnectionManager$createWelcomeHome$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.blueair.api.ConnectionManager$createWelcomeHome$1 r2 = new com.blueair.api.ConnectionManager$createWelcomeHome$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0065
            if (r4 != r5) goto L_0x005d
            int r4 = r2.I$2
            int r4 = r2.I$1
            int r7 = r2.I$0
            java.lang.Object r8 = r2.L$9
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r9 = r2.L$8
            com.blueair.api.client.DeviceClient r9 = (com.blueair.api.client.DeviceClient) r9
            java.lang.Object r10 = r2.L$7
            java.lang.Object r10 = r2.L$6
            java.util.Iterator r10 = (java.util.Iterator) r10
            java.lang.Object r11 = r2.L$5
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r12 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r12 = (kotlin.jvm.internal.Ref.ObjectRef) r12
            java.lang.Object r13 = r2.L$3
            com.blueair.core.model.WelcomeHomeLocation r13 = (com.blueair.core.model.WelcomeHomeLocation) r13
            java.lang.Object r14 = r2.L$2
            kotlin.reflect.KFunction r14 = (kotlin.reflect.KFunction) r14
            java.lang.Object r15 = r2.L$1
            com.blueair.api.ConnectionManager r15 = (com.blueair.api.ConnectionManager) r15
            java.lang.Object r5 = r2.L$0
            com.blueair.core.model.WelcomeHomeLocation r5 = (com.blueair.core.model.WelcomeHomeLocation) r5
            kotlin.ResultKt.throwOnFailure(r1)
            r6 = 1
            goto L_0x0156
        L_0x005d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0065:
            kotlin.ResultKt.throwOnFailure(r1)
            com.blueair.api.ConnectionManager$createWelcomeHome$2 r1 = com.blueair.api.ConnectionManager$createWelcomeHome$2.INSTANCE
            kotlin.reflect.KFunction r1 = (kotlin.reflect.KFunction) r1
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "Attempting to doApiCall "
            r5.<init>(r7)
            r5.append(r1)
            java.lang.String r7 = ", with "
            r5.append(r7)
            r7 = r17
            r5.append(r7)
            java.lang.String r8 = " on "
            r5.append(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            int r8 = r8.size()
            r5.append(r8)
            java.lang.String r8 = " clients"
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.d(r5, r8)
            timber.log.Timber$Forest r4 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r8 = "Client info: "
            r5.<init>(r8)
            java.util.List<com.blueair.api.client.DeviceClient> r8 = r0.clients
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r8 = new java.lang.Object[r6]
            r4.v(r5, r8)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r8 = new java.lang.UnknownError
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "None of the clients in "
            r9.<init>(r10)
            r9.append(r0)
            java.lang.String r10 = " could call "
            r9.append(r10)
            r9.append(r1)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r5.<init>(r8)
            r4.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r0.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r5 = r5.iterator()
        L_0x00ed:
            boolean r9 = r5.hasNext()
            if (r9 == 0) goto L_0x00ff
            java.lang.Object r9 = r5.next()
            boolean r10 = r9 instanceof com.blueair.api.client.CanManageWelcomeHome
            if (r10 == 0) goto L_0x00ed
            r8.add(r9)
            goto L_0x00ed
        L_0x00ff:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.Iterator r5 = r8.iterator()
            r15 = r0
            r14 = r1
            r10 = r5
            r5 = r6
            r1 = r7
            r11 = r8
            r8 = r4
            r4 = r5
        L_0x010f:
            boolean r9 = r10.hasNext()
            if (r9 == 0) goto L_0x01bf
            java.lang.Object r9 = r10.next()
            r12 = r9
            com.blueair.api.client.DeviceClient r12 = (com.blueair.api.client.DeviceClient) r12
            r13 = r14
            kotlin.jvm.functions.Function3 r13 = (kotlin.jvm.functions.Function3) r13
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r1)
            r2.L$0 = r6
            r2.L$1 = r15
            r2.L$2 = r14
            r2.L$3 = r7
            r2.L$4 = r8
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r11)
            r2.L$5 = r6
            r2.L$6 = r10
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r2.L$7 = r6
            r2.L$8 = r12
            r2.L$9 = r8
            r2.I$0 = r5
            r2.I$1 = r4
            r6 = 0
            r2.I$2 = r6
            r6 = 1
            r2.label = r6
            java.lang.Object r9 = r13.invoke(r12, r7, r2)
            if (r9 != r3) goto L_0x0150
            return r3
        L_0x0150:
            r13 = r7
            r7 = r5
            r5 = r1
            r1 = r9
            r9 = r12
            r12 = r8
        L_0x0156:
            r8.element = r1
            T r1 = r12.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            boolean r1 = r1.isSuccess()
            java.lang.String r8 = "client "
            if (r1 == 0) goto L_0x018d
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            r2.append(r9)
            java.lang.String r3 = " gave good result "
            r2.append(r3)
            T r3 = r12.element
            r2.append(r3)
            java.lang.String r3 = " for call "
            r2.append(r3)
            r2.append(r14)
            java.lang.String r2 = r2.toString()
            r6 = 0
            java.lang.Object[] r3 = new java.lang.Object[r6]
            r1.v(r2, r3)
            T r1 = r12.element
            return r1
        L_0x018d:
            timber.log.Timber$Forest r1 = timber.log.Timber.Forest
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r8)
            r6.append(r9)
            java.lang.String r8 = " gave failed result\n"
            r6.append(r8)
            T r8 = r12.element
            r6.append(r8)
            java.lang.String r8 = " for call \n"
            r6.append(r8)
            r6.append(r14)
            java.lang.String r8 = ", \nwith details:"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            r9 = 0
            java.lang.Object[] r8 = new java.lang.Object[r9]
            r1.w(r6, r8)
            r1 = r5
            r5 = r7
            r6 = r9
            r8 = r12
            r7 = r13
            goto L_0x010f
        L_0x01bf:
            T r1 = r8.element
            io.flatcircle.coroutinehelper.ApiResult r1 = (io.flatcircle.coroutinehelper.ApiResult) r1
            java.lang.Throwable r1 = r1.exceptionOrNull()
            r15.logApiError(r1)
            T r1 = r8.element
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.createWelcomeHome(com.blueair.core.model.WelcomeHomeLocation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object deleteWelcomeHome(kotlin.coroutines.Continuation<? super io.flatcircle.coroutinehelper.ApiResult<kotlin.Unit>> r15) {
        /*
            r14 = this;
            boolean r0 = r15 instanceof com.blueair.api.ConnectionManager$deleteWelcomeHome$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.blueair.api.ConnectionManager$deleteWelcomeHome$1 r0 = (com.blueair.api.ConnectionManager$deleteWelcomeHome$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.blueair.api.ConnectionManager$deleteWelcomeHome$1 r0 = new com.blueair.api.ConnectionManager$deleteWelcomeHome$1
            r0.<init>(r14, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0058
            if (r2 != r3) goto L_0x0050
            int r2 = r0.I$2
            int r2 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r6 = r0.L$7
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r0.L$6
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            java.lang.Object r8 = r0.L$5
            java.lang.Object r8 = r0.L$4
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r0.L$3
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.lang.Object r10 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r0.L$1
            kotlin.reflect.KFunction r11 = (kotlin.reflect.KFunction) r11
            java.lang.Object r12 = r0.L$0
            com.blueair.api.ConnectionManager r12 = (com.blueair.api.ConnectionManager) r12
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x012f
        L_0x0050:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x0058:
            kotlin.ResultKt.throwOnFailure(r15)
            com.blueair.api.ConnectionManager$deleteWelcomeHome$2 r15 = com.blueair.api.ConnectionManager$deleteWelcomeHome$2.INSTANCE
            kotlin.reflect.KFunction r15 = (kotlin.reflect.KFunction) r15
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Attempting to doApiCall "
            r5.<init>(r6)
            r5.append(r15)
            java.lang.String r6 = " on "
            r5.append(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            int r6 = r6.size()
            r5.append(r6)
            java.lang.String r6 = " clients"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.d(r5, r6)
            timber.log.Timber$Forest r2 = timber.log.Timber.Forest
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Client info: "
            r5.<init>(r6)
            java.util.List<com.blueair.api.client.DeviceClient> r6 = r14.clients
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r2.v(r5, r6)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            io.flatcircle.coroutinehelper.Failure r5 = new io.flatcircle.coroutinehelper.Failure
            java.lang.UnknownError r6 = new java.lang.UnknownError
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "None of the clients in "
            r7.<init>(r8)
            r7.append(r14)
            java.lang.String r8 = " could call "
            r7.append(r8)
            r7.append(r15)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            r2.element = r5
            java.util.List<com.blueair.api.client.DeviceClient> r5 = r14.clients
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Collection r6 = (java.util.Collection) r6
            java.util.Iterator r5 = r5.iterator()
        L_0x00d6:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x00e8
            java.lang.Object r7 = r5.next()
            boolean r8 = r7 instanceof com.blueair.api.client.CanManageWelcomeHome
            if (r8 == 0) goto L_0x00d6
            r6.add(r7)
            goto L_0x00d6
        L_0x00e8:
            java.util.List r6 = (java.util.List) r6
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Iterator r5 = r6.iterator()
            r12 = r14
            r11 = r15
            r8 = r5
            r9 = r6
            r6 = r2
            r2 = r4
            r5 = r2
        L_0x00f7:
            boolean r15 = r8.hasNext()
            if (r15 == 0) goto L_0x0192
            java.lang.Object r15 = r8.next()
            r7 = r15
            com.blueair.api.client.DeviceClient r7 = (com.blueair.api.client.DeviceClient) r7
            r10 = r11
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10
            r0.L$0 = r12
            r0.L$1 = r11
            r0.L$2 = r6
            java.lang.Object r13 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r13
            r0.L$4 = r8
            java.lang.Object r15 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r15)
            r0.L$5 = r15
            r0.L$6 = r7
            r0.L$7 = r6
            r0.I$0 = r5
            r0.I$1 = r2
            r0.I$2 = r4
            r0.label = r3
            java.lang.Object r15 = r10.invoke(r7, r0)
            if (r15 != r1) goto L_0x012e
            return r1
        L_0x012e:
            r10 = r6
        L_0x012f:
            r6.element = r15
            T r15 = r10.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            boolean r15 = r15.isSuccess()
            java.lang.String r6 = "client "
            if (r15 == 0) goto L_0x0165
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r6)
            r0.append(r7)
            java.lang.String r1 = " gave good result "
            r0.append(r1)
            T r1 = r10.element
            r0.append(r1)
            java.lang.String r1 = " for call "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r15.v(r0, r1)
            T r15 = r10.element
            return r15
        L_0x0165:
            timber.log.Timber$Forest r15 = timber.log.Timber.Forest
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r6)
            r13.append(r7)
            java.lang.String r6 = " gave failed result\n"
            r13.append(r6)
            T r6 = r10.element
            r13.append(r6)
            java.lang.String r6 = " for call \n"
            r13.append(r6)
            r13.append(r11)
            java.lang.String r6 = ", \nwith details:"
            r13.append(r6)
            java.lang.String r6 = r13.toString()
            java.lang.Object[] r7 = new java.lang.Object[r4]
            r15.w(r6, r7)
            r6 = r10
            goto L_0x00f7
        L_0x0192:
            T r15 = r6.element
            io.flatcircle.coroutinehelper.ApiResult r15 = (io.flatcircle.coroutinehelper.ApiResult) r15
            java.lang.Throwable r15 = r15.exceptionOrNull()
            r12.logApiError(r15)
            T r15 = r6.element
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.api.ConnectionManager.deleteWelcomeHome(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
