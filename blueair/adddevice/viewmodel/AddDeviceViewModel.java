package com.blueair.adddevice.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.api.utils.ProgressListener;
import com.blueair.auth.AuthService;
import com.blueair.auth.GigyaService;
import com.blueair.bluetooth.model.BleScannedDevice;
import com.blueair.bluetooth.service.BleDeviceError;
import com.blueair.bluetooth.service.BleDeviceService;
import com.blueair.bluetooth.service.BleDeviceState;
import com.blueair.bluetooth.service.BleScanningService;
import com.blueair.bluetooth.service.BluetoothConnectivityService;
import com.blueair.bluetooth.service.ProvisionConfig;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.BluetoothDevice;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceG4;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.DeviceUuid;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasBlueProvisionCalls;
import com.blueair.core.model.HasSKU;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import com.blueair.core.model.Ssid;
import com.blueair.core.model.WelcomeHomeLocation;
import com.blueair.core.service.HappyUserService;
import com.blueair.core.util.PersistentObjectDelegate;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import com.jacquessmuts.rxextensions.LazyPublishSubject;
import com.jacquessmuts.rxextensions.RxExtensionsKt;
import io.flatcircle.coroutinehelper.ApiResult;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeReference;
import org.kodein.type.TypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 ß\u00012\u00020\u0001:\u0002ß\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0099\u0001\u001a\u00030\u009a\u00012\b\u0010\u009b\u0001\u001a\u00030\u0093\u0001H\u0002J\n\u0010\u009c\u0001\u001a\u00030\u009a\u0001H\u0002J\u0012\u0010\u009d\u0001\u001a\u00020&2\u0007\u0010\u009e\u0001\u001a\u000204H\u0002J\u0015\u0010\u009f\u0001\u001a\u00020&2\n\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0093\u0001H\u0002J\u0013\u0010 \u0001\u001a\u00030\u009a\u00012\u0007\u0010¡\u0001\u001a\u000204H\u0002J\u0011\u0010¢\u0001\u001a\u00030\u009a\u00012\u0007\u0010£\u0001\u001a\u00020dJ\u001a\u0010¤\u0001\u001a\u00030\u009a\u00012\u0007\u0010£\u0001\u001a\u00020d2\u0007\u0010¥\u0001\u001a\u000204J%\u0010¦\u0001\u001a\u00030\u009a\u00012\u0007\u0010§\u0001\u001a\u0002042\u0007\u0010¨\u0001\u001a\u0002042\t\b\u0002\u0010©\u0001\u001a\u000204J'\u0010ª\u0001\u001a\u00030\u009a\u00012\b\u0010«\u0001\u001a\u00030\u0095\u00012\b\u0010¬\u0001\u001a\u00030\u0095\u00012\t\b\u0002\u0010©\u0001\u001a\u000204JI\u0010\u00ad\u0001\u001a\u00030\u009a\u00012\u0007\u0010®\u0001\u001a\u0002042\u0007\u0010¯\u0001\u001a\u0002042\u0007\u0010°\u0001\u001a\u0002042\u0007\u0010±\u0001\u001a\u0002042\u0007\u0010²\u0001\u001a\u0002042\u0007\u0010³\u0001\u001a\u0002042\t\b\u0002\u0010©\u0001\u001a\u000204J\u0013\u0010´\u0001\u001a\u00030\u009a\u00012\t\b\u0002\u0010©\u0001\u001a\u000204J\u0013\u0010µ\u0001\u001a\u00030\u009a\u00012\t\b\u0002\u0010©\u0001\u001a\u000204J\u0011\u0010¶\u0001\u001a\u00030\u009a\u00012\u0007\u0010·\u0001\u001a\u000204J\u001b\u0010¸\u0001\u001a\u0002042\u0007\u0010¹\u0001\u001a\u00020\u001c2\u0007\u0010º\u0001\u001a\u00020oH\u0002J\b\u0010»\u0001\u001a\u00030\u009a\u0001J\b\u0010¼\u0001\u001a\u00030\u009a\u0001J\b\u0010½\u0001\u001a\u00030\u009a\u0001J\b\u0010¾\u0001\u001a\u00030\u009a\u0001J\b\u0010¿\u0001\u001a\u00030\u009a\u0001J\n\u0010À\u0001\u001a\u00030\u009a\u0001H\u0014J\b\u0010Á\u0001\u001a\u00030\u009a\u0001J\b\u0010Â\u0001\u001a\u00030\u009a\u0001J\u0010\u0010Ã\u0001\u001a\u00020&H\u0086@¢\u0006\u0003\u0010Ä\u0001J\u0010\u0010Å\u0001\u001a\u00020&H\u0086@¢\u0006\u0003\u0010Ä\u0001J\n\u0010Æ\u0001\u001a\u00030\u009a\u0001H\u0002J\b\u0010Ç\u0001\u001a\u00030\u009a\u0001J\u0012\u0010È\u0001\u001a\u00030\u009a\u00012\b\u0010É\u0001\u001a\u00030Ê\u0001J\b\u0010Ë\u0001\u001a\u00030\u009a\u0001J\b\u0010Ì\u0001\u001a\u00030\u009a\u0001J#\u0010Í\u0001\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010g2\u0007\u0010Î\u0001\u001a\u00020d2\t\b\u0002\u0010Ï\u0001\u001a\u00020&J\b\u0010Ð\u0001\u001a\u00030\u009a\u0001J\u0010\u0010Ñ\u0001\u001a\u00020&H\u0086@¢\u0006\u0003\u0010Ä\u0001J\u001d\u0010Ò\u0001\u001a\u00030\u009a\u00012\t\u0010Ó\u0001\u001a\u0004\u0018\u00010 2\b\b\u0002\u00109\u001a\u00020&J\u001a\u0010Ô\u0001\u001a\u00030\u009a\u00012\u0007\u0010Õ\u0001\u001a\u00020dH\u0086@¢\u0006\u0003\u0010Ö\u0001J\b\u0010×\u0001\u001a\u00030\u009a\u0001J\b\u0010Ø\u0001\u001a\u00030\u009a\u0001J\u0007\u0010Ù\u0001\u001a\u00020&J\u0011\u0010Ú\u0001\u001a\u00030\u009a\u00012\u0007\u0010Û\u0001\u001a\u000204J\u0013\u0010Ü\u0001\u001a\u00030\u009a\u00012\t\b\u0002\u0010Ý\u0001\u001a\u00020&J\b\u0010Þ\u0001\u001a\u00030\u009a\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\"¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000b\u001a\u0004\b*\u0010+R\"\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00106\"\u0004\b?\u00108R\u001a\u0010@\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00106\"\u0004\bB\u00108R\u001a\u0010C\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010:\"\u0004\bE\u0010<R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020G0.¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020J0.¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R!\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bO\u0010PR\u0017\u0010S\u001a\b\u0012\u0004\u0012\u00020&0.¢\u0006\b\n\u0000\u001a\u0004\bT\u00100R\u001a\u0010U\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010:\"\u0004\bW\u0010<R\u0016\u0010X\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000RC\u0010\\\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040[2\u0012\u0010Z\u001a\u000e\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u0002040[8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\ba\u0010b\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u001d\u0010c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\be\u0010$R!\u0010f\u001a\b\u0012\u0004\u0012\u00020&0g8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bj\u0010\u000b\u001a\u0004\bh\u0010iR\u0011\u0010k\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\bk\u0010:R\u0017\u0010l\u001a\b\u0012\u0004\u0012\u00020&0.¢\u0006\b\n\u0000\u001a\u0004\bm\u00100R\u0019\u0010n\u001a\n\u0012\u0004\u0012\u00020o\u0018\u00010g8F¢\u0006\u0006\u001a\u0004\bp\u0010iR\u0019\u0010q\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010g8F¢\u0006\u0006\u001a\u0004\bs\u0010iR\u0013\u0010t\u001a\u0004\u0018\u00010u8F¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0011\u0010x\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\by\u0010:R\u001e\u0010{\u001a\u00020&2\u0006\u0010z\u001a\u00020&@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b{\u0010:R\u0013\u0010|\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0013\u0010~\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b~\u0010}R\u0013\u0010\u007f\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b\u007f\u0010}R\u0016\u0010\u0080\u0001\u001a\u0004\u0018\u00010r8F¢\u0006\b\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u0017\u0010\u0083\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0084\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001040\u0085\u00018F¢\u0006\b\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u0001048F¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u00106R%\u0010\u008a\u0001\u001a\u0004\u0018\u00010d2\b\u0010z\u001a\u0004\u0018\u00010d@BX\u0086\u000e¢\u0006\n\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001R\u0015\u0010\u008d\u0001\u001a\u0004\u0018\u0001048F¢\u0006\u0007\u001a\u0005\b\u008e\u0001\u00106R\u000f\u0010\u008f\u0001\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0090\u0001\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0091\u0001\u001a\n\u0012\u0005\u0012\u00030\u0093\u00010\u0092\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0094\u0001\u001a\u00030\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0096\u0001\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006à\u0001"},
   d2 = {"Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "gigyaService", "Lcom/blueair/auth/GigyaService;", "getGigyaService", "()Lcom/blueair/auth/GigyaService;", "gigyaService$delegate", "bleScanningService", "Lcom/blueair/bluetooth/service/BleScanningService;", "getBleScanningService", "()Lcom/blueair/bluetooth/service/BleScanningService;", "bleScanningService$delegate", "btConnectivityService", "Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "getBtConnectivityService", "()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", "btConnectivityService$delegate", "selectedBleDeviceService", "Lcom/blueair/bluetooth/service/BleDeviceService;", "_ssids", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/blueair/core/model/Ssid;", "ssids", "Lkotlinx/coroutines/flow/StateFlow;", "getSsids", "()Lkotlinx/coroutines/flow/StateFlow;", "_isRefreshingSsids", "", "isRefreshingSsids", "happyUserService", "Lcom/blueair/core/service/HappyUserService;", "getHappyUserService", "()Lcom/blueair/core/service/HappyUserService;", "happyUserService$delegate", "selectedSsid", "Landroidx/lifecycle/MutableLiveData;", "getSelectedSsid", "()Landroidx/lifecycle/MutableLiveData;", "setSelectedSsid", "(Landroidx/lifecycle/MutableLiveData;)V", "password", "", "getPassword$adddevice_otherRelease", "()Ljava/lang/String;", "setPassword$adddevice_otherRelease", "(Ljava/lang/String;)V", "isHiddenNetwork", "()Z", "setHiddenNetwork", "(Z)V", "rand", "getRand", "setRand", "text", "getText", "setText", "hasSharedError", "getHasSharedError", "setHasSharedError", "onboardingDevice", "Lcom/blueair/core/model/DeviceG4;", "getOnboardingDevice", "currentScreen", "Lcom/blueair/adddevice/viewmodel/AddDeviceScreen;", "getCurrentScreen", "actionPublisher", "Lio/reactivex/subjects/PublishSubject;", "Lcom/blueair/adddevice/viewmodel/AddDeviceAction;", "getActionPublisher", "()Lio/reactivex/subjects/PublishSubject;", "actionPublisher$delegate", "Lcom/jacquessmuts/rxextensions/LazyPublishSubject;", "lvBlockNavigation", "getLvBlockNavigation", "polling", "getPolling", "setPolling", "onboardedDevices", "Lcom/blueair/core/model/HasBlueCloudFunctions;", "<set-?>", "", "bleDeviceMacNameCache", "getBleDeviceMacNameCache", "()Ljava/util/Map;", "setBleDeviceMacNameCache", "(Ljava/util/Map;)V", "bleDeviceMacNameCache$delegate", "Lcom/blueair/core/util/PersistentObjectDelegate;", "bleDevicesFlow", "Lcom/blueair/core/model/BluetoothDevice;", "getBleDevicesFlow", "bluetoothConnectionStateObserver", "Lio/reactivex/Observable;", "getBluetoothConnectionStateObserver", "()Lio/reactivex/Observable;", "bluetoothConnectionStateObserver$delegate", "isBluetoothEnabled", "lvDeviceScanned", "getLvDeviceScanned", "selectedBleDeviceStateObserver", "Lcom/blueair/bluetooth/service/BleDeviceState;", "getSelectedBleDeviceStateObserver", "selectedBleDeviceErrorObserver", "Lcom/blueair/bluetooth/service/BleDeviceError;", "getSelectedBleDeviceErrorObserver", "selectedBleDevice", "Landroid/bluetooth/BluetoothDevice;", "getSelectedBleDevice", "()Landroid/bluetooth/BluetoothDevice;", "hasSelectedBleDevice", "getHasSelectedBleDevice", "value", "isRandRegisterFailed", "isSelectedBleDeviceWifiConnected", "()Ljava/lang/Boolean;", "isSelectedBleDeviceConnected", "isSelectedBleDeviceBounded", "selectedBleDeviceError", "getSelectedBleDeviceError", "()Lcom/blueair/bluetooth/service/BleDeviceError;", "_selectedDeviceName", "liveSelectedDeviceName", "Landroidx/lifecycle/LiveData;", "getLiveSelectedDeviceName", "()Landroidx/lifecycle/LiveData;", "selectedDeviceName", "getSelectedDeviceName", "selectedUiDevice", "getSelectedUiDevice", "()Lcom/blueair/core/model/BluetoothDevice;", "detectedDeviceUuid", "getDetectedDeviceUuid", "wifiStateListenerAdded", "logSessionUuid", "logEvents", "", "Lcom/blueair/core/model/AnalyticEvent$OnboardingLogEvent;", "wifiListRefreshCount", "", "stayScreenName", "stayScreenStartTime", "", "addLogEvent", "", "event", "sendLogEvents", "isStepSuccess", "result", "isStepError", "uploadOnboardingLog", "message", "logStep0SelectDevice", "device", "logStep1ConnectionInstructions", "connectType", "logStep2Connecting", "bleEstablishSession", "bleStartProvision", "extra", "logStep3WifiList", "refreshCount", "ssidCount", "logStep4WifiPassword", "cloudRegion", "registerForOnboarding", "bleConfigProvision", "bleConfigWifi", "bleApplyWifi", "blePollWifiConnected", "logStep5OnboardingSuccess", "logStep5OnboardingFailure", "recordResume", "screenName", "getStateResult", "service", "state", "showConnectionLost", "restart", "clearOnboardedDevices", "reset", "resetScanResult", "onCleared", "disableSoftAp", "gotoWifiList", "provisionSelectedBleDevice", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pollwifiConnected", "pollDeviceBounded", "refreshSsidsList", "unbindNetwork", "activity", "Landroid/app/Activity;", "startBluetoothScanning", "stopBluetoothScanning", "selectBluetoothDevice", "uiDevice", "forceNew", "deselectBluetoothDevice", "connectAndEstablishSessionAndStartProvisioningForBleDeviceSync", "gotoWifiPassword", "ssid", "removeOwnedDevice", "bluetoothDevice", "(Lcom/blueair/core/model/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gotoSuccessScreen", "gotoEnterNameScreen", "isUserLoggedIn", "setDeviceName", "nuName", "blockNavigation", "block", "addDevice", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddDeviceViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceViewModel.class, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceViewModel.class, "gigyaService", "getGigyaService()Lcom/blueair/auth/GigyaService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceViewModel.class, "bleScanningService", "getBleScanningService()Lcom/blueair/bluetooth/service/BleScanningService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceViewModel.class, "btConnectivityService", "getBtConnectivityService()Lcom/blueair/bluetooth/service/BluetoothConnectivityService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceViewModel.class, "happyUserService", "getHappyUserService()Lcom/blueair/core/service/HappyUserService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(AddDeviceViewModel.class, "actionPublisher", "getActionPublisher()Lio/reactivex/subjects/PublishSubject;", 0))), Reflection.mutableProperty1((MutablePropertyReference1)(new MutablePropertyReference1Impl(AddDeviceViewModel.class, "bleDeviceMacNameCache", "getBleDeviceMacNameCache()Ljava/util/Map;", 0)))};
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   public static final int MAX_PROVISION_ATTEMPTS = 2;
   private final MutableStateFlow _isRefreshingSsids;
   private final MutableLiveData _selectedDeviceName;
   private final MutableStateFlow _ssids;
   private final LazyPublishSubject actionPublisher$delegate;
   private final Lazy authService$delegate;
   private final PersistentObjectDelegate bleDeviceMacNameCache$delegate;
   private final StateFlow bleDevicesFlow;
   private final Lazy bleScanningService$delegate;
   private final Lazy bluetoothConnectionStateObserver$delegate;
   private final Lazy btConnectivityService$delegate;
   private final MutableLiveData currentScreen;
   private final Lazy gigyaService$delegate;
   private final Lazy happyUserService$delegate;
   private boolean hasSharedError;
   private boolean isHiddenNetwork;
   private boolean isRandRegisterFailed;
   private final StateFlow isRefreshingSsids;
   private final List logEvents;
   private String logSessionUuid;
   private final MutableLiveData lvBlockNavigation;
   private final MutableLiveData lvDeviceScanned;
   private List onboardedDevices;
   private final MutableLiveData onboardingDevice;
   private String password;
   private volatile boolean polling;
   private String rand;
   private BleDeviceService selectedBleDeviceService;
   private MutableLiveData selectedSsid;
   private BluetoothDevice selectedUiDevice;
   private final StateFlow ssids;
   private String stayScreenName;
   private long stayScreenStartTime;
   private String text;
   private int wifiListRefreshCount;
   private boolean wifiStateListenerAdded;

   // $FF: synthetic method
   public static Unit $r8$lambda$NMLT04EZ_jrfZagcfy_GKU6joJI(AddDeviceViewModel var0, BleDeviceState var1) {
      return gotoWifiPassword$lambda$11(var0, var1);
   }

   // $FF: synthetic method
   public static Observable $r8$lambda$dAlpaXLnJtGwTjuBvN81Y0EkMJQ(AddDeviceViewModel var0) {
      return bluetoothConnectionStateObserver_delegate$lambda$4(var0);
   }

   public AddDeviceViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var3 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var5 = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var3, AuthService.class)), (Object)null);
      KProperty[] var4 = $$delegatedProperties;
      Boolean var7 = false;
      this.authService$delegate = var5.provideDelegate(this, var4[0]);
      JVMTypeToken var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.gigyaService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, GigyaService.class)), (Object)null).provideDelegate(this, var4[1]);
      var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.bleScanningService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, BleScanningService.class)), (Object)null).provideDelegate(this, var4[2]);
      var8 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var8, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.btConnectivityService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var8, BluetoothConnectivityService.class)), (Object)null).provideDelegate(this, var4[3]);
      MutableStateFlow var11 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
      this._ssids = var11;
      this.ssids = FlowKt.asStateFlow(var11);
      var11 = StateFlowKt.MutableStateFlow(var7);
      this._isRefreshingSsids = var11;
      this.isRefreshingSsids = FlowKt.asStateFlow(var11);
      JVMTypeToken var13 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var13, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.happyUserService$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var13, HappyUserService.class)), (Object)null).provideDelegate(this, var4[4]);
      this.selectedSsid = new MutableLiveData();
      this.rand = "";
      this.text = "";
      this.onboardingDevice = new MutableLiveData();
      MutableLiveData var6 = new MutableLiveData();
      this.currentScreen = var6;
      this.actionPublisher$delegate = new LazyPublishSubject();
      this.lvBlockNavigation = new MutableLiveData(var7);
      this.bleDeviceMacNameCache$delegate = new PersistentObjectDelegate((Context)var1, "ble_device_mac_name_map_file", MapsKt.emptyMap(), (Type)Map.class, new Type[]{String.class, String.class});
      this.bleDevicesFlow = FlowKt.stateIn(new Flow(FlowKt.filterNotNull((Flow)this.getBleScanningService().getResultFlow()), this) {
         final Flow $this_unsafeTransform$inlined;
         final AddDeviceViewModel this$0;

         public {
            this.$this_unsafeTransform$inlined = var1;
            this.this$0 = var2;
         }

         public Object collect(FlowCollector var1, Continuation var2) {
            Object var3 = this.$this_unsafeTransform$inlined.collect(new FlowCollector(var1, this.this$0) {
               final FlowCollector $this_unsafeFlow;
               final AddDeviceViewModel this$0;

               public {
                  this.$this_unsafeFlow = var1;
                  this.this$0 = var2;
               }

               public final Object emit(Object var1, Continuation var2) {
                  label274: {
                     if (var2 instanceof <undefinedtype>) {
                        <undefinedtype> var7 = (<undefinedtype>)var2;
                        if ((var7.label & Integer.MIN_VALUE) != 0) {
                           var7.label += Integer.MIN_VALUE;
                           var35 = var7;
                           break label274;
                        }
                     }

                     var35 = new ContinuationImpl(this, var2) {
                        int I$0;
                        int I$1;
                        int I$2;
                        int I$3;
                        int I$4;
                        Object L$0;
                        Object L$1;
                        Object L$10;
                        Object L$11;
                        Object L$12;
                        Object L$13;
                        Object L$14;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        Object L$5;
                        Object L$6;
                        Object L$7;
                        Object L$8;
                        Object L$9;
                        int label;
                        Object result;
                        final <undefinedtype> this$0;

                        public {
                           this.this$0 = var1;
                        }

                        public final Object invokeSuspend(Object var1) {
                           this.result = var1;
                           this.label |= Integer.MIN_VALUE;
                           return this.this$0.emit((Object)null, (Continuation)this);
                        }
                     };
                  }

                  Object var19 = ((<undefinedtype>)var35).result;
                  Object var24 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var3 = ((<undefinedtype>)var35).label;
                  int var4;
                  int var5;
                  int var6;
                  Object var8;
                  Object var9;
                  BleScannedDevice var22;
                  FlowCollector var26;
                  Object var36;
                  Iterator var40;
                  FlowCollector var42;
                  Object var50;
                  String var64;
                  Collection var72;
                  Iterable var102;
                  Continuation var111;
                  Iterable var116;
                  List var123;
                  Object var135;
                  Collection var144;
                  if (var3 != 0) {
                     if (var3 != 1) {
                        if (var3 != 2) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var3 = ((<undefinedtype>)var35).I$0;
                        var26 = (FlowCollector)((<undefinedtype>)var35).L$3;
                        Object var28 = ((<undefinedtype>)var35).L$2;
                        <undefinedtype> var29 = (<undefinedtype>)((<undefinedtype>)var35).L$1;
                        Object var30 = ((<undefinedtype>)var35).L$0;
                        ResultKt.throwOnFailure(var19);
                        return Unit.INSTANCE;
                     }

                     var3 = ((<undefinedtype>)var35).I$4;
                     var3 = ((<undefinedtype>)var35).I$3;
                     var5 = ((<undefinedtype>)var35).I$2;
                     var6 = ((<undefinedtype>)var35).I$1;
                     var4 = ((<undefinedtype>)var35).I$0;
                     AddDeviceViewModel var21 = (AddDeviceViewModel)((<undefinedtype>)var35).L$14;
                     Collection var16 = (Collection)((<undefinedtype>)var35).L$13;
                     BleScannedDevice var14 = (BleScannedDevice)((<undefinedtype>)var35).L$12;
                     Object var25 = ((<undefinedtype>)var35).L$11;
                     var40 = (Iterator)((<undefinedtype>)var35).L$10;
                     Collection var18 = (Collection)((<undefinedtype>)var35).L$9;
                     Iterable var13 = (Iterable)((<undefinedtype>)var35).L$8;
                     Iterable var17 = (Iterable)((<undefinedtype>)var35).L$7;
                     List var12 = (List)((<undefinedtype>)var35).L$6;
                     Continuation var10 = (Continuation)((<undefinedtype>)var35).L$5;
                     FlowCollector var15 = (FlowCollector)((<undefinedtype>)var35).L$4;
                     var26 = (FlowCollector)((<undefinedtype>)var35).L$3;
                     var9 = ((<undefinedtype>)var35).L$2;
                     var8 = (<undefinedtype>)((<undefinedtype>)var35).L$1;
                     var135 = ((<undefinedtype>)var35).L$0;
                     ResultKt.throwOnFailure(var19);
                     var50 = var35;
                     var36 = var135;
                     var21.onboardedDevices = (List)var19;
                     Collection var23 = var18;
                     Iterable var134 = var17;
                     var111 = var10;
                     var144 = var16;
                     var42 = var15;
                     var22 = var14;
                     var116 = var13;
                     var123 = var12;
                     var102 = var134;
                     var135 = var50;
                     var72 = var23;
                     String var49 = var14.getDevice().getName();
                     String var84 = "";
                     if (var49 == null) {
                        var49 = "";
                        var64 = var22.getDevice().getAddress();
                        if (var64 == null) {
                           var64 = "";
                        }
                     } else {
                        var64 = var22.getDevice().getAddress();
                        if (var64 == null) {
                           var64 = "";
                        }
                     }

                     CharSequence var94 = (CharSequence)var49;
                     if (var94.length() > 0) {
                        if (((CharSequence)var64).length() > 0 && !Intrinsics.areEqual(this.this$0.getBleDeviceMacNameCache().get(var64), var49)) {
                           AddDeviceViewModel var152 = this.this$0;
                           var152.setBleDeviceMacNameCache(MapsKt.plus(var152.getBleDeviceMacNameCache(), TuplesKt.to(var64, var49)));
                        }

                        var50 = var94;
                        if (var94.length() == 0) {
                           var50 = (String)this.this$0.getBleDeviceMacNameCache().get(var64);
                           if (var50 == null) {
                              var50 = var84;
                           }
                        }
                     } else {
                        var50 = var94;
                        if (var94.length() == 0) {
                           var50 = (String)this.this$0.getBleDeviceMacNameCache().get(var64);
                           if (var50 == null) {
                              var50 = var84;
                           }
                        }
                     }
                  } else {
                     ResultKt.throwOnFailure(var19);
                     FlowCollector var95 = this.$this_unsafeFlow;
                     var111 = (Continuation)var35;
                     List var43 = (List)var1;
                     var102 = (Iterable)var43;
                     var72 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var102, 10)));
                     var40 = var102.iterator();
                     Iterable var65 = var102;
                     var3 = 0;
                     var5 = 0;
                     var6 = 0;
                     var4 = 0;
                     var8 = var35;
                     Object var85 = var1;
                     var50 = var35;
                     var36 = var1;
                     Collection var31 = var72;
                     if (!var40.hasNext()) {
                        List var34 = (List)var72;
                        ((<undefinedtype>)var50).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                        ((<undefinedtype>)var50).L$1 = SpillingKt.nullOutSpilledVariable(var8);
                        ((<undefinedtype>)var50).L$2 = SpillingKt.nullOutSpilledVariable(var85);
                        ((<undefinedtype>)var50).L$3 = SpillingKt.nullOutSpilledVariable(var95);
                        ((<undefinedtype>)var50).L$4 = null;
                        ((<undefinedtype>)var50).L$5 = null;
                        ((<undefinedtype>)var50).L$6 = null;
                        ((<undefinedtype>)var50).L$7 = null;
                        ((<undefinedtype>)var50).L$8 = null;
                        ((<undefinedtype>)var50).L$9 = null;
                        ((<undefinedtype>)var50).L$10 = null;
                        ((<undefinedtype>)var50).L$11 = null;
                        ((<undefinedtype>)var50).L$12 = null;
                        ((<undefinedtype>)var50).L$13 = null;
                        ((<undefinedtype>)var50).L$14 = null;
                        ((<undefinedtype>)var50).I$0 = var4;
                        ((<undefinedtype>)var50).label = 2;
                        if (var95.emit(var34, (Continuation)var50) == var24) {
                           return var24;
                        }

                        return Unit.INSTANCE;
                     }

                     Object var74 = var40.next();
                     BleScannedDevice var117 = (BleScannedDevice)var74;
                     Collection var124 = (Collection)this.this$0.onboardedDevices;
                     if (var124 != null) {
                        if (var124.isEmpty()) {
                           AddDeviceViewModel var147 = this.this$0;
                           DeviceManager var125 = var147.getDeviceManager();
                           ((<undefinedtype>)var50).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                           ((<undefinedtype>)var50).L$1 = SpillingKt.nullOutSpilledVariable(var8);
                           ((<undefinedtype>)var50).L$2 = SpillingKt.nullOutSpilledVariable(var85);
                           ((<undefinedtype>)var50).L$3 = SpillingKt.nullOutSpilledVariable(var95);
                           ((<undefinedtype>)var50).L$4 = var95;
                           ((<undefinedtype>)var50).L$5 = SpillingKt.nullOutSpilledVariable(var111);
                           ((<undefinedtype>)var50).L$6 = SpillingKt.nullOutSpilledVariable(var43);
                           ((<undefinedtype>)var50).L$7 = SpillingKt.nullOutSpilledVariable(var102);
                           ((<undefinedtype>)var50).L$8 = SpillingKt.nullOutSpilledVariable(var102);
                           ((<undefinedtype>)var50).L$9 = var31;
                           ((<undefinedtype>)var50).L$10 = var40;
                           ((<undefinedtype>)var50).L$11 = SpillingKt.nullOutSpilledVariable(var74);
                           ((<undefinedtype>)var50).L$12 = var117;
                           ((<undefinedtype>)var50).L$13 = var31;
                           ((<undefinedtype>)var50).L$14 = var147;
                           ((<undefinedtype>)var50).I$0 = var4;
                           ((<undefinedtype>)var50).I$1 = var6;
                           ((<undefinedtype>)var50).I$2 = var5;
                           ((<undefinedtype>)var50).I$3 = var3;
                           ((<undefinedtype>)var50).I$4 = 0;
                           ((<undefinedtype>)var50).label = 1;
                           Object var126 = var125.getBlueDevices((Continuation)var50);
                           if (var126 == var24) {
                              return var24;
                           }

                           Collection var75 = var31;
                           Continuation var136 = var111;
                           Iterable var112 = var102;
                           BleScannedDevice var103 = var117;
                           Collection var118 = var31;
                           var26 = var95;
                           var9 = var85;
                           BleScannedDevice var86 = var103;
                           Collection var104 = var75;
                           Iterable var76 = var65;
                           List var66 = var43;
                           Continuation var44 = var136;
                           var147.onboardedDevices = (List)var126;
                           Collection var153 = var118;
                           Iterable var137 = var112;
                           var111 = var44;
                           var144 = var104;
                           var42 = var95;
                           var22 = var86;
                           var116 = var76;
                           var123 = var66;
                           var102 = var137;
                           var135 = var50;
                           var72 = var153;
                        } else {
                           var144 = var31;
                           var22 = var117;
                           var72 = var31;
                           var135 = var50;
                           var123 = var43;
                           var116 = var102;
                           var42 = var95;
                           var9 = var85;
                           var26 = var95;
                        }
                     } else {
                        AddDeviceViewModel var148 = this.this$0;
                        DeviceManager var127 = var148.getDeviceManager();
                        ((<undefinedtype>)var50).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                        ((<undefinedtype>)var50).L$1 = SpillingKt.nullOutSpilledVariable(var8);
                        ((<undefinedtype>)var50).L$2 = SpillingKt.nullOutSpilledVariable(var85);
                        ((<undefinedtype>)var50).L$3 = SpillingKt.nullOutSpilledVariable(var95);
                        ((<undefinedtype>)var50).L$4 = var95;
                        ((<undefinedtype>)var50).L$5 = SpillingKt.nullOutSpilledVariable(var111);
                        ((<undefinedtype>)var50).L$6 = SpillingKt.nullOutSpilledVariable(var43);
                        ((<undefinedtype>)var50).L$7 = SpillingKt.nullOutSpilledVariable(var102);
                        ((<undefinedtype>)var50).L$8 = SpillingKt.nullOutSpilledVariable(var102);
                        ((<undefinedtype>)var50).L$9 = var31;
                        ((<undefinedtype>)var50).L$10 = var40;
                        ((<undefinedtype>)var50).L$11 = SpillingKt.nullOutSpilledVariable(var74);
                        ((<undefinedtype>)var50).L$12 = var117;
                        ((<undefinedtype>)var50).L$13 = var31;
                        ((<undefinedtype>)var50).L$14 = var148;
                        ((<undefinedtype>)var50).I$0 = var4;
                        ((<undefinedtype>)var50).I$1 = var6;
                        ((<undefinedtype>)var50).I$2 = var5;
                        ((<undefinedtype>)var50).I$3 = var3;
                        ((<undefinedtype>)var50).I$4 = 0;
                        ((<undefinedtype>)var50).label = 1;
                        Object var128 = var127.getBlueDevices((Continuation)var50);
                        if (var128 == var24) {
                           return var24;
                        }

                        Collection var77 = var31;
                        Continuation var138 = var111;
                        Iterable var113 = var102;
                        BleScannedDevice var105 = var117;
                        Collection var119 = var31;
                        var26 = var95;
                        var9 = var85;
                        BleScannedDevice var87 = var105;
                        Collection var106 = var77;
                        Iterable var78 = var65;
                        List var67 = var43;
                        Continuation var45 = var138;
                        var148.onboardedDevices = (List)var128;
                        Collection var154 = var119;
                        Iterable var139 = var113;
                        var111 = var45;
                        var144 = var106;
                        var42 = var95;
                        var22 = var87;
                        var116 = var78;
                        var123 = var67;
                        var102 = var139;
                        var135 = var50;
                        var72 = var154;
                     }

                     String var52 = var22.getDevice().getName();
                     String var88 = "";
                     if (var52 == null) {
                        var52 = "";
                        var64 = var22.getDevice().getAddress();
                        if (var64 == null) {
                           var64 = "";
                        }
                     } else {
                        var64 = var22.getDevice().getAddress();
                        if (var64 == null) {
                           var64 = "";
                        }
                     }

                     CharSequence var96 = (CharSequence)var52;
                     if (var96.length() > 0) {
                        if (((CharSequence)var64).length() > 0 && !Intrinsics.areEqual(this.this$0.getBleDeviceMacNameCache().get(var64), var52)) {
                           AddDeviceViewModel var155 = this.this$0;
                           var155.setBleDeviceMacNameCache(MapsKt.plus(var155.getBleDeviceMacNameCache(), TuplesKt.to(var64, var52)));
                        }

                        var50 = var96;
                        if (var96.length() == 0) {
                           var50 = (String)this.this$0.getBleDeviceMacNameCache().get(var64);
                           if (var50 == null) {
                              var50 = var88;
                           }
                        }
                     } else {
                        var50 = var96;
                        if (var96.length() == 0) {
                           var50 = (String)this.this$0.getBleDeviceMacNameCache().get(var64);
                           if (var50 == null) {
                              var50 = var88;
                           }
                        }
                     }
                  }

                  while(true) {
                     BluetoothDevice var89 = new BluetoothDevice((String)var50, var64, var22.getConnectable(), (Boolean)null, 8, (DefaultConstructorMarker)null);
                     List var53 = this.this$0.onboardedDevices;
                     Collection var32;
                     FlowCollector var41;
                     List var46;
                     Object var56;
                     Iterable var68;
                     Object var90;
                     FlowCollector var97;
                     if (var53 != null) {
                        Iterator var57 = ((Iterable)var53).iterator();

                        while(true) {
                           if (!var57.hasNext()) {
                              Object var60 = null;
                              HasBlueCloudFunctions var61 = (HasBlueCloudFunctions)var60;
                              Boolean var62;
                              if (var61 != null) {
                                 var62 = Boxing.boxBoolean(var61.isOnline());
                              } else {
                                 var62 = null;
                              }

                              var89.setOnline(var62);
                              var144.add(var89);
                              var97 = var26;
                              var32 = var72;
                              var90 = var9;
                              var41 = var42;
                              var56 = var135;
                              var46 = var123;
                              var68 = var116;
                              break;
                           }

                           Object var69 = var57.next();
                           String var149 = ((HasBlueCloudFunctions)var69).getMac().toLowerCase(Locale.ROOT);
                           Intrinsics.checkNotNullExpressionValue(var149, "toLowerCase(...)");
                           String var98 = var89.getWifiMac().toLowerCase(Locale.ROOT);
                           Intrinsics.checkNotNullExpressionValue(var98, "toLowerCase(...)");
                           if (Intrinsics.areEqual(var149, var98)) {
                              HasBlueCloudFunctions var58 = (HasBlueCloudFunctions)var69;
                              Boolean var59;
                              if (var58 != null) {
                                 var59 = Boxing.boxBoolean(var58.isOnline());
                              } else {
                                 var59 = null;
                              }

                              var89.setOnline(var59);
                              var144.add(var89);
                              var97 = var26;
                              var32 = var72;
                              var90 = var9;
                              var41 = var42;
                              var56 = var135;
                              var46 = var123;
                              var68 = var116;
                              break;
                           }
                        }
                     } else {
                        var56 = null;
                        Boolean var55;
                        if (var56 != null) {
                           var55 = Boxing.boxBoolean(((HasBlueCloudFunctions)var56).isOnline());
                        } else {
                           var55 = null;
                        }

                        var89.setOnline(var55);
                        var144.add(var89);
                        var97 = var26;
                        var32 = var72;
                        var90 = var9;
                        var41 = var42;
                        var56 = var135;
                        var46 = var123;
                        var68 = var116;
                     }

                     if (!var40.hasNext()) {
                        List var33 = (List)var32;
                        ((<undefinedtype>)var56).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                        ((<undefinedtype>)var56).L$1 = SpillingKt.nullOutSpilledVariable(var8);
                        ((<undefinedtype>)var56).L$2 = SpillingKt.nullOutSpilledVariable(var90);
                        ((<undefinedtype>)var56).L$3 = SpillingKt.nullOutSpilledVariable(var97);
                        ((<undefinedtype>)var56).L$4 = null;
                        ((<undefinedtype>)var56).L$5 = null;
                        ((<undefinedtype>)var56).L$6 = null;
                        ((<undefinedtype>)var56).L$7 = null;
                        ((<undefinedtype>)var56).L$8 = null;
                        ((<undefinedtype>)var56).L$9 = null;
                        ((<undefinedtype>)var56).L$10 = null;
                        ((<undefinedtype>)var56).L$11 = null;
                        ((<undefinedtype>)var56).L$12 = null;
                        ((<undefinedtype>)var56).L$13 = null;
                        ((<undefinedtype>)var56).L$14 = null;
                        ((<undefinedtype>)var56).I$0 = var4;
                        ((<undefinedtype>)var56).label = 2;
                        if (var41.emit(var33, (Continuation)var56) == var24) {
                           return var24;
                        }

                        return Unit.INSTANCE;
                     }

                     Object var79 = var40.next();
                     BleScannedDevice var120 = (BleScannedDevice)var79;
                     Collection var129 = (Collection)this.this$0.onboardedDevices;
                     if (var129 != null) {
                        if (var129.isEmpty()) {
                           AddDeviceViewModel var150 = this.this$0;
                           DeviceManager var130 = var150.getDeviceManager();
                           ((<undefinedtype>)var56).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                           ((<undefinedtype>)var56).L$1 = SpillingKt.nullOutSpilledVariable(var8);
                           ((<undefinedtype>)var56).L$2 = SpillingKt.nullOutSpilledVariable(var90);
                           ((<undefinedtype>)var56).L$3 = SpillingKt.nullOutSpilledVariable(var97);
                           ((<undefinedtype>)var56).L$4 = var41;
                           ((<undefinedtype>)var56).L$5 = SpillingKt.nullOutSpilledVariable(var111);
                           ((<undefinedtype>)var56).L$6 = SpillingKt.nullOutSpilledVariable(var46);
                           ((<undefinedtype>)var56).L$7 = SpillingKt.nullOutSpilledVariable(var102);
                           ((<undefinedtype>)var56).L$8 = SpillingKt.nullOutSpilledVariable(var68);
                           ((<undefinedtype>)var56).L$9 = var32;
                           ((<undefinedtype>)var56).L$10 = var40;
                           ((<undefinedtype>)var56).L$11 = SpillingKt.nullOutSpilledVariable(var79);
                           ((<undefinedtype>)var56).L$12 = var120;
                           ((<undefinedtype>)var56).L$13 = var32;
                           ((<undefinedtype>)var56).L$14 = var150;
                           ((<undefinedtype>)var56).I$0 = var4;
                           ((<undefinedtype>)var56).I$1 = var6;
                           ((<undefinedtype>)var56).I$2 = var5;
                           ((<undefinedtype>)var56).I$3 = var3;
                           ((<undefinedtype>)var56).I$4 = 0;
                           ((<undefinedtype>)var56).label = 1;
                           Object var131 = var130.getBlueDevices((Continuation)var56);
                           if (var131 == var24) {
                              return var24;
                           }

                           Collection var80 = var32;
                           FlowCollector var145 = var41;
                           Continuation var140 = var111;
                           Iterable var114 = var102;
                           BleScannedDevice var107 = var120;
                           Collection var121 = var32;
                           var26 = var97;
                           var9 = var90;
                           var97 = var145;
                           BleScannedDevice var91 = var107;
                           Collection var108 = var80;
                           Iterable var81 = var68;
                           List var70 = var46;
                           Continuation var47 = var140;
                           var150.onboardedDevices = (List)var131;
                           Collection var156 = var121;
                           Iterable var141 = var114;
                           var111 = var47;
                           var144 = var108;
                           var42 = var97;
                           var22 = var91;
                           var116 = var81;
                           var123 = var70;
                           var102 = var141;
                           var135 = var56;
                           var72 = var156;
                        } else {
                           var144 = var32;
                           var22 = var120;
                           var72 = var32;
                           var135 = var56;
                           var123 = var46;
                           var116 = var68;
                           var42 = var41;
                           var9 = var90;
                           var26 = var97;
                        }
                     } else {
                        AddDeviceViewModel var151 = this.this$0;
                        DeviceManager var132 = var151.getDeviceManager();
                        ((<undefinedtype>)var56).L$0 = SpillingKt.nullOutSpilledVariable(var36);
                        ((<undefinedtype>)var56).L$1 = SpillingKt.nullOutSpilledVariable(var8);
                        ((<undefinedtype>)var56).L$2 = SpillingKt.nullOutSpilledVariable(var90);
                        ((<undefinedtype>)var56).L$3 = SpillingKt.nullOutSpilledVariable(var97);
                        ((<undefinedtype>)var56).L$4 = var41;
                        ((<undefinedtype>)var56).L$5 = SpillingKt.nullOutSpilledVariable(var111);
                        ((<undefinedtype>)var56).L$6 = SpillingKt.nullOutSpilledVariable(var46);
                        ((<undefinedtype>)var56).L$7 = SpillingKt.nullOutSpilledVariable(var102);
                        ((<undefinedtype>)var56).L$8 = SpillingKt.nullOutSpilledVariable(var68);
                        ((<undefinedtype>)var56).L$9 = var32;
                        ((<undefinedtype>)var56).L$10 = var40;
                        ((<undefinedtype>)var56).L$11 = SpillingKt.nullOutSpilledVariable(var79);
                        ((<undefinedtype>)var56).L$12 = var120;
                        ((<undefinedtype>)var56).L$13 = var32;
                        ((<undefinedtype>)var56).L$14 = var151;
                        ((<undefinedtype>)var56).I$0 = var4;
                        ((<undefinedtype>)var56).I$1 = var6;
                        ((<undefinedtype>)var56).I$2 = var5;
                        ((<undefinedtype>)var56).I$3 = var3;
                        ((<undefinedtype>)var56).I$4 = 0;
                        ((<undefinedtype>)var56).label = 1;
                        Object var133 = var132.getBlueDevices((Continuation)var56);
                        if (var133 == var24) {
                           return var24;
                        }

                        Collection var82 = var32;
                        FlowCollector var146 = var41;
                        Continuation var142 = var111;
                        Iterable var115 = var102;
                        BleScannedDevice var109 = var120;
                        Collection var122 = var32;
                        var26 = var97;
                        var9 = var90;
                        var97 = var146;
                        BleScannedDevice var92 = var109;
                        Collection var110 = var82;
                        Iterable var83 = var68;
                        List var71 = var46;
                        Continuation var48 = var142;
                        var151.onboardedDevices = (List)var133;
                        Collection var157 = var122;
                        Iterable var143 = var115;
                        var111 = var48;
                        var144 = var110;
                        var42 = var97;
                        var22 = var92;
                        var116 = var83;
                        var123 = var71;
                        var102 = var143;
                        var135 = var56;
                        var72 = var157;
                     }

                     String var63 = var22.getDevice().getName();
                     String var93 = "";
                     if (var63 == null) {
                        var63 = "";
                        var64 = var22.getDevice().getAddress();
                        if (var64 == null) {
                           var64 = "";
                        }
                     } else {
                        var64 = var22.getDevice().getAddress();
                        if (var64 == null) {
                           var64 = "";
                        }
                     }

                     CharSequence var101 = (CharSequence)var63;
                     if (var101.length() > 0) {
                        if (((CharSequence)var64).length() > 0 && !Intrinsics.areEqual(this.this$0.getBleDeviceMacNameCache().get(var64), var63)) {
                           AddDeviceViewModel var158 = this.this$0;
                           var158.setBleDeviceMacNameCache(MapsKt.plus(var158.getBleDeviceMacNameCache(), TuplesKt.to(var64, var63)));
                        }

                        var50 = var101;
                        if (var101.length() == 0) {
                           var50 = (String)this.this$0.getBleDeviceMacNameCache().get(var64);
                           if (var50 == null) {
                              var50 = var93;
                           }
                        }
                     } else {
                        var50 = var101;
                        if (var101.length() == 0) {
                           var50 = (String)this.this$0.getBleDeviceMacNameCache().get(var64);
                           if (var50 == null) {
                              var50 = var93;
                           }
                        }
                     }
                  }
               }
            }, var2);
            return var3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? var3 : Unit.INSTANCE;
         }
      }, ViewModelKt.getViewModelScope((ViewModel)this), SharingStarted.Companion.getLazily(), CollectionsKt.emptyList());
      this.bluetoothConnectionStateObserver$delegate = LazyKt.lazy(new AddDeviceViewModel$$ExternalSyntheticLambda0(this));
      this.lvDeviceScanned = new MutableLiveData(var7);
      this._selectedDeviceName = new MutableLiveData((Object)null);
      this.logSessionUuid = "";
      this.logEvents = (List)(new ArrayList());
      this.stayScreenName = "";
      var6.setValue(AddDeviceScreen.ChooseDevice);
   }

   private final void addLogEvent(AnalyticEvent.OnboardingLogEvent var1) {
      AnalyticEvent.OnboardingLogEvent var4;
      label16: {
         var4 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
         if (var4 != null) {
            Map var3 = var4.getPayload();
            if (var3 != null) {
               var4 = (AnalyticEvent.OnboardingLogEvent)var3.get("step");
               break label16;
            }
         }

         var4 = null;
      }

      if (!Intrinsics.areEqual(var4, var1.getPayload().get("step"))) {
         this.logEvents.add(var1);
      }
   }

   // $FF: synthetic method
   public static void blockNavigation$default(AddDeviceViewModel var0, boolean var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = true;
      }

      var0.blockNavigation(var1);
   }

   private static final Observable bluetoothConnectionStateObserver_delegate$lambda$4(AddDeviceViewModel var0) {
      return var0.getBtConnectivityService().getStateObserver().hide();
   }

   private final AuthService getAuthService() {
      return (AuthService)this.authService$delegate.getValue();
   }

   private final Map getBleDeviceMacNameCache() {
      return (Map)this.bleDeviceMacNameCache$delegate.getValue(this, $$delegatedProperties[6]);
   }

   private final BleScanningService getBleScanningService() {
      return (BleScanningService)this.bleScanningService$delegate.getValue();
   }

   private final BluetoothConnectivityService getBtConnectivityService() {
      return (BluetoothConnectivityService)this.btConnectivityService$delegate.getValue();
   }

   private final GigyaService getGigyaService() {
      return (GigyaService)this.gigyaService$delegate.getValue();
   }

   private final HappyUserService getHappyUserService() {
      return (HappyUserService)this.happyUserService$delegate.getValue();
   }

   private final String getStateResult(BleDeviceService var1, BleDeviceState var2) {
      if (var1.getState().getCode() >= var2.getCode()) {
         return "success";
      } else {
         BleDeviceError var3 = var1.getError();
         String var4 = "unknown";
         if (var3 != null && var3.getStateOccurred().getCode() <= var2.getCode()) {
            StringBuilder var5 = new StringBuilder();
            var5.append(var3.getStateOccurred().getName());
            var5.append(", ");
            var5.append(var3.getMessage());
            var4 = var5.toString();
         }

         StringBuilder var6 = new StringBuilder("failed: ");
         var6.append(var4);
         return var6.toString();
      }
   }

   // $FF: synthetic method
   public static void gotoWifiPassword$default(AddDeviceViewModel var0, Ssid var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      var0.gotoWifiPassword(var1, var2);
   }

   private static final Unit gotoWifiPassword$lambda$11(AddDeviceViewModel var0, BleDeviceState var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      if (Intrinsics.areEqual(var1, BleDeviceState.WifiConnected.INSTANCE)) {
         var0.pollDeviceBounded();
      }

      return Unit.INSTANCE;
   }

   private final boolean isStepError(AnalyticEvent.OnboardingLogEvent var1) {
      if (var1 == null) {
         return false;
      } else {
         Iterable var3 = (Iterable)var1.getPayload().values();
         if (var3 instanceof Collection && ((Collection)var3).isEmpty()) {
            return false;
         } else {
            for(Object var2 : var3) {
               if (var2 instanceof String && StringsKt.startsWith$default((String)var2, "failed", false, 2, (Object)null) && !Intrinsics.areEqual(var2, "failed: unknown")) {
                  return true;
               }
            }

            return false;
         }
      }
   }

   private final boolean isStepSuccess(String var1) {
      return Intrinsics.areEqual(var1, "success");
   }

   // $FF: synthetic method
   public static void logStep2Connecting$default(AddDeviceViewModel var0, String var1, String var2, String var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = "";
      }

      var0.logStep2Connecting(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void logStep3WifiList$default(AddDeviceViewModel var0, int var1, int var2, String var3, int var4, Object var5) {
      if ((var4 & 4) != 0) {
         var3 = "";
      }

      var0.logStep3WifiList(var1, var2, var3);
   }

   // $FF: synthetic method
   public static void logStep4WifiPassword$default(AddDeviceViewModel var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, int var8, Object var9) {
      if ((var8 & 64) != 0) {
         var7 = "";
      }

      var0.logStep4WifiPassword(var1, var2, var3, var4, var5, var6, var7);
   }

   // $FF: synthetic method
   public static void logStep5OnboardingFailure$default(AddDeviceViewModel var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = "";
      }

      var0.logStep5OnboardingFailure(var1);
   }

   // $FF: synthetic method
   public static void logStep5OnboardingSuccess$default(AddDeviceViewModel var0, String var1, int var2, Object var3) {
      if ((var2 & 1) != 0) {
         var1 = "";
      }

      var0.logStep5OnboardingSuccess(var1);
   }

   private final void pollDeviceBounded() {
      BuildersKt.launch$default(this, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, (Continuation)null) {
         Object L$0;
         int label;
         final AddDeviceViewModel this$0;

         {
            this.this$0 = var1;
         }

         public final Continuation create(Object var1, Continuation var2) {
            return (Continuation)(new <anonymous constructor>(this.this$0, var2));
         }

         public final Object invoke(CoroutineScope var1, Continuation var2) {
            return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
         }

         public final Object invokeSuspend(Object var1) {
            boolean var3;
            label23: {
               Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               Object var5;
               AddDeviceViewModel var8;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  var8 = (AddDeviceViewModel)this.L$0;
                  ResultKt.throwOnFailure(var1);
                  var5 = var1;
               } else {
                  ResultKt.throwOnFailure(var1);
                  var7 = this.this$0;
                  BleDeviceService var6 = var7.selectedBleDeviceService;
                  if (var6 == null) {
                     var3 = false;
                     break label23;
                  }

                  Continuation var9 = (Continuation)this;
                  this.L$0 = var7;
                  this.label = 1;
                  var5 = var6.pollDeviceBounded(var9);
                  if (var5 == var4) {
                     return var4;
                  }

                  var8 = var7;
               }

               var3 = (Boolean)var5;
               var7 = var8;
            }

            var7.setPolling(var3);
            return Unit.INSTANCE;
         }
      }, 3, (Object)null);
   }

   // $FF: synthetic method
   public static Observable selectBluetoothDevice$default(AddDeviceViewModel var0, BluetoothDevice var1, boolean var2, int var3, Object var4) {
      if ((var3 & 2) != 0) {
         var2 = false;
      }

      return var0.selectBluetoothDevice(var1, var2);
   }

   private final void sendLogEvents() {
      if (this.logEvents.size() > 0) {
         AnalyticEvent.OnboardingLogEvent var1 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
         if (var1 != null && !this.isStepError(var1) && !Intrinsics.areEqual(var1.getPayload().get("step"), 5)) {
            this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.ScreenStayEvent(this.logSessionUuid, this.stayScreenName, (int)((System.currentTimeMillis() - this.stayScreenStartTime) / (long)1000), (String)null, 8, (DefaultConstructorMarker)null));
         }
      }

      for(AnalyticEvent.OnboardingLogEvent var3 : (Iterable)this.logEvents) {
         this.getAnalyticsService().event(var3);
      }

      this.logEvents.clear();
      this.wifiListRefreshCount = 0;
   }

   private final void setBleDeviceMacNameCache(Map var1) {
      this.bleDeviceMacNameCache$delegate.setValue(this, $$delegatedProperties[6], var1);
   }

   private final void uploadOnboardingLog(String var1) {
      if (((CharSequence)var1).length() != 0) {
         if (this.isStepError((AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents))) {
            BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
               final String $message;
               int label;
               final AddDeviceViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$message = var2;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$message, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                  int var2 = this.label;
                  if (var2 != 0) {
                     if (var2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     ResultKt.throwOnFailure(var1);
                  } else {
                     ResultKt.throwOnFailure(var1);
                     DeviceManager var5 = this.this$0.getDeviceManager();
                     Context var9 = (Context)this.this$0.getApplication();
                     IssueType var7 = IssueType.ONBOARDING;
                     LogLength var6 = LogLength.M10;
                     String var10 = this.$message;
                     ProgressListener var8 = new ProgressListener() {
                        public void onFailure(Throwable var1) {
                           Intrinsics.checkNotNullParameter(var1, "t");
                           Timber.Forest var2 = Timber.Forest;
                           StringBuilder var3 = new StringBuilder("upload onboarding log failed: ");
                           var3.append(var1.getMessage());
                           var2.e(var1, var3.toString(), new Object[0]);
                        }

                        public void update(long var1, long var3, boolean var5) {
                           int var6 = (int)((long)100 * var1 / var3);
                           Timber.Forest var8 = Timber.Forest;
                           StringBuilder var7 = new StringBuilder("upload onboarding log: ");
                           var7.append(var6);
                           var7.append("% done");
                           var8.d(var7.toString(), new Object[0]);
                        }
                     };
                     Continuation var4 = (Continuation)this;
                     this.label = 1;
                     if (var5.uploadLog(var9, var7, var6, var10, var8, var4) == var3) {
                        return var3;
                     }
                  }

                  return Unit.INSTANCE;
               }
            }, 2, (Object)null);
         }
      }
   }

   public final void addDevice() {
      String var1 = this.getDetectedDeviceUuid();
      CharSequence var2 = (CharSequence)var1;
      if (var2 != null && var2.length() != 0) {
         BluetoothDevice var4 = this.selectedUiDevice;
         if (var4 != null) {
            HasSKU var3 = var4.toDevice(var1, var1);
            if (var3 != null) {
               this.getDeviceManager().addOrUpdateDevice(var3);
            }
         }
      }

   }

   public final void blockNavigation(boolean var1) {
      this.lvBlockNavigation.setValue(var1);
   }

   public final void clearOnboardedDevices() {
      this.onboardedDevices = null;
   }

   public final Object connectAndEstablishSessionAndStartProvisioningForBleDeviceSync(Continuation var1) {
      label34: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var7 = var4;
               break label34;
            }
         }

         var7 = new ContinuationImpl(this, var1) {
            Object L$0;
            int label;
            Object result;
            final AddDeviceViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.connectAndEstablishSessionAndStartProvisioningForBleDeviceSync((Continuation)this);
            }
         };
      }

      BleDeviceService var9 = (BleDeviceService)((<undefinedtype>)var7).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var7).label;
      BleDeviceService var8;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var8 = (BleDeviceService)((<undefinedtype>)var7).L$0;
         ResultKt.throwOnFailure(var9);
      } else {
         ResultKt.throwOnFailure(var9);
         this.stopBluetoothScanning();
         var9 = this.selectedBleDeviceService;
         if (var9 == null) {
            return Boxing.boxBoolean(false);
         }

         ((<undefinedtype>)var7).L$0 = var9;
         ((<undefinedtype>)var7).label = 1;
         Object var5 = var9.connectAndEstablishSessionAndStartProvisioningSync((Continuation)var7);
         if (var5 == var6) {
            return var6;
         }

         var8 = var9;
         var9 = (BleDeviceService)var5;
      }

      boolean var3 = (Boolean)var9;
      if (var3) {
         logStep2Connecting$default(this, "success", "success", (String)null, 4, (Object)null);
      } else {
         logStep2Connecting$default(this, this.getStateResult(var8, BleDeviceState.SessionEstablished.INSTANCE), this.getStateResult(var8, BleDeviceState.ProvisioningConfigured5.INSTANCE), (String)null, 4, (Object)null);
      }

      return Boxing.boxBoolean(var3);
   }

   public final void deselectBluetoothDevice() {
      Timber.Forest var2 = Timber.Forest;
      StringBuilder var1 = new StringBuilder("deselectBluetoothDevice: selectedBleDeviceService = ");
      var1.append(this.selectedBleDeviceService);
      var2.d(var1.toString(), new Object[0]);
      BleDeviceService var3 = this.selectedBleDeviceService;
      if (var3 != null) {
         var3.disconnect();
      }

      this.selectedBleDeviceService = null;
      this.selectedUiDevice = null;
   }

   public final void disableSoftAp() {
      DeviceG4 var1 = (DeviceG4)this.onboardingDevice.getValue();
      if (var1 != null) {
         BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var1, (Continuation)null) {
            final DeviceG4 $device;
            int label;
            final AddDeviceViewModel this$0;

            {
               this.this$0 = var1;
               this.$device = var2;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  DeviceManager var5 = this.this$0.getDeviceManager();
                  HasBlueProvisionCalls var4 = this.$device;
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  if (var5.switchOffSoftAp(var4, var6) == var3) {
                     return var3;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 3, (Object)null);
      }

   }

   public final PublishSubject getActionPublisher() {
      return this.actionPublisher$delegate.getValue(this, $$delegatedProperties[5]);
   }

   public final StateFlow getBleDevicesFlow() {
      return this.bleDevicesFlow;
   }

   public final Observable getBluetoothConnectionStateObserver() {
      Object var1 = this.bluetoothConnectionStateObserver$delegate.getValue();
      Intrinsics.checkNotNullExpressionValue(var1, "getValue(...)");
      return (Observable)var1;
   }

   public final MutableLiveData getCurrentScreen() {
      return this.currentScreen;
   }

   public final String getDetectedDeviceUuid() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.getDetectedDeviceUuid() : null;
   }

   public final boolean getHasSelectedBleDevice() {
      return this.selectedBleDeviceService != null;
   }

   public final boolean getHasSharedError() {
      return this.hasSharedError;
   }

   public final LiveData getLiveSelectedDeviceName() {
      return Transformations.distinctUntilChanged((LiveData)this._selectedDeviceName);
   }

   public final MutableLiveData getLvBlockNavigation() {
      return this.lvBlockNavigation;
   }

   public final MutableLiveData getLvDeviceScanned() {
      return this.lvDeviceScanned;
   }

   public final MutableLiveData getOnboardingDevice() {
      return this.onboardingDevice;
   }

   public final String getPassword$adddevice_otherRelease() {
      return this.password;
   }

   public final boolean getPolling() {
      return this.polling;
   }

   public final String getRand() {
      return this.rand;
   }

   public final android.bluetooth.BluetoothDevice getSelectedBleDevice() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.getCurrentDevice() : null;
   }

   public final BleDeviceError getSelectedBleDeviceError() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.getError() : null;
   }

   public final Observable getSelectedBleDeviceErrorObserver() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.getDeviceErrorObserver() : null;
   }

   public final Observable getSelectedBleDeviceStateObserver() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.getDeviceStateObserver() : null;
   }

   public final String getSelectedDeviceName() {
      return (String)this._selectedDeviceName.getValue();
   }

   public final MutableLiveData getSelectedSsid() {
      return this.selectedSsid;
   }

   public final BluetoothDevice getSelectedUiDevice() {
      return this.selectedUiDevice;
   }

   public final StateFlow getSsids() {
      return this.ssids;
   }

   public final String getText() {
      return this.text;
   }

   public final void gotoEnterNameScreen() {
      BluetoothDevice var1 = this.selectedUiDevice;
      if (var1 != null) {
         DeviceType var2 = var1.getDeviceType();
         if (var2 != null && var2.isNewPlatform()) {
            this.getHappyUserService().setG4NewBlueOnboardStamp(System.currentTimeMillis());
         }
      }

      this.currentScreen.setValue(AddDeviceScreen.EnterDeviceName);
   }

   public final void gotoSuccessScreen() {
      this.currentScreen.setValue(AddDeviceScreen.Success);
   }

   public final void gotoWifiList() {
      this.currentScreen.setValue(AddDeviceScreen.WifiList);
      BaseViewModel.showProgress$default(this, false, 1, (Object)null);
   }

   public final void gotoWifiPassword(Ssid var1, boolean var2) {
      this.selectedSsid.setValue(var1);
      this.isHiddenNetwork = var2;
      if (!this.wifiStateListenerAdded) {
         this.wifiStateListenerAdded = true;
         Observable var3 = this.getSelectedBleDeviceStateObserver();
         if (var3 != null) {
            var3 = RxExtensionsKt.computationThread(var3);
            if (var3 != null) {
               RxExtensionsKt.subscribeAndLogE(var3, new AddDeviceViewModel$$ExternalSyntheticLambda1(this));
            }
         }
      }

      String var4;
      if (var1 != null) {
         var4 = var1.getAuth();
      } else {
         var4 = null;
      }

      if (Intrinsics.areEqual(var4, "Open")) {
         this.password = null;
         BaseViewModel.showProgress$default(this, false, 1, (Object)null);
         BuildersKt.launch$default(this, (CoroutineContext)Dispatchers.getMain(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
            boolean Z$0;
            int label;
            final AddDeviceViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Continuation create(Object var1, Continuation var2) {
               return (Continuation)(new <anonymous constructor>(this.this$0, var2));
            }

            public final Object invoke(CoroutineScope var1, Continuation var2) {
               return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object var1) {
               Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
               int var2 = this.label;
               if (var2 != 0) {
                  if (var2 != 1) {
                     if (var2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                     }

                     ResultKt.throwOnFailure(var1);
                     return Unit.INSTANCE;
                  }

                  ResultKt.throwOnFailure(var1);
               } else {
                  ResultKt.throwOnFailure(var1);
                  CoroutineContext var7 = (CoroutineContext)Dispatchers.getIO();
                  Function2 var4 = new Function2(this.this$0, (Continuation)null) {
                     int label;
                     final AddDeviceViewModel this$0;

                     {
                        this.this$0 = var1;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, var2));
                     }

                     public final Object invoke(CoroutineScope var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int var2 = this.label;
                        if (var2 != 0) {
                           if (var2 == 1) {
                              ResultKt.throwOnFailure(var1);
                              return var1;
                           } else {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }
                        } else {
                           ResultKt.throwOnFailure(var1);
                           AddDeviceViewModel var4 = this.this$0;
                           Continuation var5 = (Continuation)this;
                           this.label = 1;
                           Object var6 = var4.provisionSelectedBleDevice(var5);
                           return var6 == var3 ? var3 : var6;
                        }
                     }
                  };
                  Continuation var6 = (Continuation)this;
                  this.label = 1;
                  Object var9 = BuildersKt.withContext(var7, var4, var6);
                  var1 = var9;
                  if (var9 == var5) {
                     return var5;
                  }
               }

               boolean var3 = (Boolean)var1;
               if (var3) {
                  AddDeviceViewModel var10 = this.this$0;
                  Continuation var8 = (Continuation)this;
                  this.Z$0 = var3;
                  this.label = 2;
                  if (var10.pollwifiConnected(var8) == var5) {
                     return var5;
                  }
               }

               return Unit.INSTANCE;
            }
         }, 2, (Object)null);
      } else {
         this.currentScreen.setValue(AddDeviceScreen.WifiPassword);
      }
   }

   public final boolean isBluetoothEnabled() {
      return this.getBtConnectivityService().isBluetoothEnabled();
   }

   public final boolean isHiddenNetwork() {
      return this.isHiddenNetwork;
   }

   public final boolean isRandRegisterFailed() {
      return this.isRandRegisterFailed;
   }

   public final StateFlow isRefreshingSsids() {
      return this.isRefreshingSsids;
   }

   public final Boolean isSelectedBleDeviceBounded() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.isBounded() : null;
   }

   public final Boolean isSelectedBleDeviceConnected() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.isConnected() : null;
   }

   public final Boolean isSelectedBleDeviceWifiConnected() {
      BleDeviceService var1 = this.selectedBleDeviceService;
      return var1 != null ? var1.isWifiConnected() : null;
   }

   public final boolean isUserLoggedIn() {
      return (Boolean)this.getAuthService().isUserLoggedIn().getValue();
   }

   public final void logStep0SelectDevice(BluetoothDevice var1) {
      Intrinsics.checkNotNullParameter(var1, "device");
      this.sendLogEvents();
      String var2 = UUID.randomUUID().toString();
      Intrinsics.checkNotNullExpressionValue(var2, "toString(...)");
      this.logSessionUuid = var2;
      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.SelectDevice(this.logSessionUuid, var1.getSku(), var1.getWifiMac(), var1.getFamilyName(), var1.getModelName(), (String)null, 32, (DefaultConstructorMarker)null));
      Timber.Forest var6 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("logStep0SelectDevice: ");
      AnalyticEvent.OnboardingLogEvent var4 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var5;
      if (var4 != null) {
         var5 = var4.getPayload();
      } else {
         var5 = null;
      }

      var3.append(var5);
      var6.d(var3.toString(), new Object[0]);
   }

   public final void logStep1ConnectionInstructions(BluetoothDevice var1, String var2) {
      Intrinsics.checkNotNullParameter(var1, "device");
      Intrinsics.checkNotNullParameter(var2, "connectType");
      String var4;
      if (var1.getButtonPressNeeded()) {
         if (var1.getHasNoAutoButton()) {
            var4 = "fan";
         } else {
            var4 = "auto";
         }
      } else {
         var4 = "null";
      }

      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.ConnectInstructions(this.logSessionUuid, var4, var2, (String)null, 8, (DefaultConstructorMarker)null));
      Timber.Forest var7 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("logStep1ConnectionInstructions: ");
      AnalyticEvent.OnboardingLogEvent var5 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var6;
      if (var5 != null) {
         var6 = var5.getPayload();
      } else {
         var6 = null;
      }

      var3.append(var6);
      var7.d(var3.toString(), new Object[0]);
   }

   public final void logStep2Connecting(String var1, String var2, String var3) {
      Intrinsics.checkNotNullParameter(var1, "bleEstablishSession");
      Intrinsics.checkNotNullParameter(var2, "bleStartProvision");
      Intrinsics.checkNotNullParameter(var3, "extra");
      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.Connecting(this.logSessionUuid, var1, var2, var3));
      Timber.Forest var5 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("logStep2Connecting: ");
      AnalyticEvent.OnboardingLogEvent var9 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var10;
      if (var9 != null) {
         var10 = var9.getPayload();
      } else {
         var10 = null;
      }

      var4.append(var10);
      var5.d(var4.toString(), new Object[0]);
      if (!this.isStepSuccess(var1)) {
         StringBuilder var8 = new StringBuilder();
         var8.append(this.logSessionUuid);
         var8.append(": step 2 connecting: bleEstablishSession: ");
         var8.append(var1);
         var1 = var8.toString();
      } else if (!this.isStepSuccess(var2)) {
         StringBuilder var7 = new StringBuilder();
         var7.append(this.logSessionUuid);
         var7.append(": step 2 connecting: bleStartProvision: ");
         var7.append(var2);
         var1 = var7.toString();
      } else {
         var1 = "";
      }

      this.uploadOnboardingLog(var1);
   }

   public final void logStep3WifiList(int var1, int var2, String var3) {
      Intrinsics.checkNotNullParameter(var3, "extra");
      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.WifiList(this.logSessionUuid, var1, var2, var3));
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var5 = new StringBuilder("logStep3WifiList: ");
      AnalyticEvent.OnboardingLogEvent var6 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var7;
      if (var6 != null) {
         var7 = var6.getPayload();
      } else {
         var7 = null;
      }

      var5.append(var7);
      var4.d(var5.toString(), new Object[0]);
   }

   public final void logStep4WifiPassword(String var1, String var2, String var3, String var4, String var5, String var6, String var7) {
      Intrinsics.checkNotNullParameter(var1, "cloudRegion");
      Intrinsics.checkNotNullParameter(var2, "registerForOnboarding");
      Intrinsics.checkNotNullParameter(var3, "bleConfigProvision");
      Intrinsics.checkNotNullParameter(var4, "bleConfigWifi");
      Intrinsics.checkNotNullParameter(var5, "bleApplyWifi");
      Intrinsics.checkNotNullParameter(var6, "blePollWifiConnected");
      Intrinsics.checkNotNullParameter(var7, "extra");
      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.WifiPassword(this.logSessionUuid, var1, var2, var3, var4, var5, var6, var7));
      Timber.Forest var15 = Timber.Forest;
      StringBuilder var16 = new StringBuilder("logStep4WifiPassword: ");
      AnalyticEvent.OnboardingLogEvent var8 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var9;
      if (var8 != null) {
         var9 = var8.getPayload();
      } else {
         var9 = null;
      }

      var16.append(var9);
      var15.d(var16.toString(), new Object[0]);
      String var11;
      if (!this.isStepSuccess(var2)) {
         StringBuilder var10 = new StringBuilder();
         var10.append(this.logSessionUuid);
         var10.append(": step 4 wifi_password: registerForOnboarding: ");
         var10.append(var2);
         var11 = var10.toString();
      } else if (!this.isStepSuccess(var3)) {
         StringBuilder var12 = new StringBuilder();
         var12.append(this.logSessionUuid);
         var12.append(": step 4 wifi_password: bleConfigProvision: ");
         var12.append(var3);
         var11 = var12.toString();
      } else if (!this.isStepSuccess(var4)) {
         StringBuilder var13 = new StringBuilder();
         var13.append(this.logSessionUuid);
         var13.append(": step 4 wifi_password: bleConfigWifi: ");
         var13.append(var4);
         var11 = var13.toString();
      } else if (!this.isStepSuccess(var5)) {
         StringBuilder var14 = new StringBuilder();
         var14.append(this.logSessionUuid);
         var14.append(": step 4 wifi_password: bleApplyWifi: ");
         var14.append(var5);
         var11 = var14.toString();
      } else {
         var11 = "";
      }

      this.uploadOnboardingLog(var11);
   }

   public final void logStep5OnboardingFailure(String var1) {
      Intrinsics.checkNotNullParameter(var1, "extra");
      BleDeviceService var2 = this.selectedBleDeviceService;
      String var8;
      if (var2 == null) {
         var8 = "failed: null BleDeviceService";
      } else {
         var8 = this.getStateResult(var2, BleDeviceState.Bounded.INSTANCE);
      }

      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.Onboarding(this.logSessionUuid, var8, var1));
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("logStep5OnboardingFailure: ");
      AnalyticEvent.OnboardingLogEvent var5 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var6;
      if (var5 != null) {
         var6 = var5.getPayload();
      } else {
         var6 = null;
      }

      var4.append(var6);
      var3.d(var4.toString(), new Object[0]);
      StringBuilder var7 = new StringBuilder();
      var7.append(this.logSessionUuid);
      var7.append(": step 5 onboarding: ble_poll_device_bound: ");
      var7.append(var8);
      this.uploadOnboardingLog(var7.toString());
   }

   public final void logStep5OnboardingSuccess(String var1) {
      Intrinsics.checkNotNullParameter(var1, "extra");
      this.addLogEvent(new AnalyticEvent.OnboardingLogEvent.Onboarding(this.logSessionUuid, "success", var1));
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var2 = new StringBuilder("logStep5OnboardingSuccess: ");
      AnalyticEvent.OnboardingLogEvent var4 = (AnalyticEvent.OnboardingLogEvent)CollectionsKt.lastOrNull(this.logEvents);
      Map var5;
      if (var4 != null) {
         var5 = var4.getPayload();
      } else {
         var5 = null;
      }

      var2.append(var5);
      var3.d(var2.toString(), new Object[0]);
   }

   protected void onCleared() {
      Timber.Forest.v("onCleared", new Object[0]);
      super.onCleared();
      this.sendLogEvents();
      this.reset();
   }

   public final Object pollwifiConnected(Continuation var1) {
      label35: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var1;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var7 = var4;
               break label35;
            }
         }

         var7 = new ContinuationImpl(this, var1) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final AddDeviceViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.pollwifiConnected((Continuation)this);
            }
         };
      }

      BleDeviceService var10 = (BleDeviceService)((<undefinedtype>)var7).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var7).label;
      boolean var3;
      String var5;
      Object var8;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var5 = (String)((<undefinedtype>)var7).L$1;
         BleDeviceService var12 = (BleDeviceService)((<undefinedtype>)var7).L$0;
         ResultKt.throwOnFailure(var10);
         var8 = var10;
         var10 = var12;
      } else {
         ResultKt.throwOnFailure(var10);
         var10 = this.selectedBleDeviceService;
         var5 = this.getGigyaService().getBlueCloudDomain().tag();
         if (var10 == null) {
            logStep4WifiPassword$default(this, var5, "success", "success", "success", "success", "failed: null BleDeviceService", (String)null, 64, (Object)null);
            var3 = false;
            return Boxing.boxBoolean(var3);
         }

         ((<undefinedtype>)var7).L$0 = var10;
         ((<undefinedtype>)var7).L$1 = var5;
         ((<undefinedtype>)var7).label = 1;
         var8 = var10.pollWifiConnectionStatus((Continuation)var7);
         if (var8 == var6) {
            return var6;
         }
      }

      Boolean var9 = (Boolean)var8;
      if (var9) {
         logStep4WifiPassword$default(this, var5, "success", "success", "success", "success", "success", (String)null, 64, (Object)null);
      } else {
         logStep4WifiPassword$default(this, var5, "success", "success", "success", "success", this.getStateResult(var10, BleDeviceState.PollingWifiConfigStatus.INSTANCE), (String)null, 64, (Object)null);
      }

      var3 = var9;
      return Boxing.boxBoolean(var3);
   }

   public final Object provisionSelectedBleDevice(Continuation var1) {
      label215: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var7 = (<undefinedtype>)var1;
            if ((var7.label & Integer.MIN_VALUE) != 0) {
               var7.label += Integer.MIN_VALUE;
               var20 = var7;
               break label215;
            }
         }

         var20 = new ContinuationImpl(this, var1) {
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;
            Object result;
            final AddDeviceViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.provisionSelectedBleDevice((Continuation)this);
            }
         };
      }

      boolean var6;
      String var17;
      Object var19;
      int var31;
      BleDeviceService var53;
      Pair var63;
      String var69;
      String var73;
      ProvisionConfig var76;
      Object var81;
      DeviceG4 var88;
      ApiResult var96;
      Object var102;
      label219: {
         int var33;
         label207: {
            Object var37 = ((<undefinedtype>)var20).result;
            var19 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            var31 = ((<undefinedtype>)var20).label;
            var102 = null;
            var6 = false;
            int var3;
            ApiResult var38;
            DeviceG4 var51;
            BleDeviceService var68;
            if (var31 != 0) {
               if (var31 != 1) {
                  if (var31 != 2) {
                     if (var31 != 3) {
                        if (var31 != 4) {
                           if (var31 != 5) {
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                           }

                           var31 = ((<undefinedtype>)var20).I$0;
                           String var54 = (String)((<undefinedtype>)var20).L$7;
                           var54 = (String)((<undefinedtype>)var20).L$6;
                           ProvisionConfig var56 = (ProvisionConfig)((<undefinedtype>)var20).L$5;
                           String var64 = (String)((<undefinedtype>)var20).L$4;
                           Pair var57 = (Pair)((<undefinedtype>)var20).L$3;
                           ApiResult var58 = (ApiResult)((<undefinedtype>)var20).L$2;
                           DeviceG4 var59 = (DeviceG4)((<undefinedtype>)var20).L$1;
                           BleDeviceService var60 = (BleDeviceService)((<undefinedtype>)var20).L$0;
                           ResultKt.throwOnFailure(var37);
                           Boolean var40 = (Boolean)var37;
                           if (!var40) {
                              logStep4WifiPassword$default(this, var64, "success", "success", "success", this.getStateResult(var60, BleDeviceState.WifiConfigApplied.INSTANCE), "", (String)null, 64, (Object)null);
                           }

                           var6 = var40;
                           return Boxing.boxBoolean(var6);
                        }

                        var31 = ((<undefinedtype>)var20).I$0;
                        var73 = (String)((<undefinedtype>)var20).L$7;
                        var17 = (String)((<undefinedtype>)var20).L$6;
                        var76 = (ProvisionConfig)((<undefinedtype>)var20).L$5;
                        var69 = (String)((<undefinedtype>)var20).L$4;
                        var63 = (Pair)((<undefinedtype>)var20).L$3;
                        var96 = (ApiResult)((<undefinedtype>)var20).L$2;
                        var88 = (DeviceG4)((<undefinedtype>)var20).L$1;
                        var53 = (BleDeviceService)((<undefinedtype>)var20).L$0;
                        ResultKt.throwOnFailure(var37);
                        var102 = var20;
                        var81 = var37;
                        break label219;
                     }

                     var31 = ((<undefinedtype>)var20).I$0;
                     var76 = (ProvisionConfig)((<undefinedtype>)var20).L$5;
                     var69 = (String)((<undefinedtype>)var20).L$4;
                     var63 = (Pair)((<undefinedtype>)var20).L$3;
                     ApiResult var52 = (ApiResult)((<undefinedtype>)var20).L$2;
                     DeviceG4 var93 = (DeviceG4)((<undefinedtype>)var20).L$1;
                     BleDeviceService var85 = (BleDeviceService)((<undefinedtype>)var20).L$0;
                     ResultKt.throwOnFailure(var37);
                     Object var72 = var20;
                     var81 = var37;
                     DeviceG4 var39 = var93;
                     BleDeviceService var21 = var85;
                     if (!(Boolean)var81) {
                        logStep4WifiPassword$default(this, var69, "success", this.getStateResult(var85, BleDeviceState.ProvisioningConfigured5.INSTANCE), "", "", "", (String)null, 64, (Object)null);
                        return Boxing.boxBoolean(var6);
                     }

                     Ssid var86 = (Ssid)this.selectedSsid.getValue();
                     String var80 = (String)var102;
                     if (var86 != null) {
                        var80 = var86.getSsid();
                     }

                     String var87 = this.password;
                     Timber.Forest var94 = Timber.Forest;
                     StringBuilder var101 = new StringBuilder("provisionSelectedBleDevice: ssid = ");
                     var101.append(var80);
                     var101.append("}, password = ");
                     var101.append(var87);
                     var94.d(var101.toString(), new Object[0]);
                     if (var80 == null) {
                        logStep4WifiPassword$default(this, var69, "success", "success", "failed: null ssid", "", "", (String)null, 64, (Object)null);
                        return Boxing.boxBoolean(var6);
                     }

                     ((<undefinedtype>)var72).L$0 = var21;
                     ((<undefinedtype>)var72).L$1 = SpillingKt.nullOutSpilledVariable(var39);
                     ((<undefinedtype>)var72).L$2 = SpillingKt.nullOutSpilledVariable(var52);
                     ((<undefinedtype>)var72).L$3 = SpillingKt.nullOutSpilledVariable(var63);
                     ((<undefinedtype>)var72).L$4 = var69;
                     ((<undefinedtype>)var72).L$5 = SpillingKt.nullOutSpilledVariable(var76);
                     ((<undefinedtype>)var72).L$6 = SpillingKt.nullOutSpilledVariable(var80);
                     ((<undefinedtype>)var72).L$7 = SpillingKt.nullOutSpilledVariable(var87);
                     ((<undefinedtype>)var72).I$0 = var31;
                     ((<undefinedtype>)var72).label = 4;
                     Object var95 = var21.configureWifiSync(var80, var87, (Continuation)var72);
                     if (var95 == var19) {
                        return var19;
                     }

                     var17 = var80;
                     var81 = var95;
                     var102 = var72;
                     var73 = var87;
                     var96 = var52;
                     var88 = var39;
                     var53 = var21;
                     break label219;
                  }

                  var33 = ((<undefinedtype>)var20).I$1;
                  var31 = ((<undefinedtype>)var20).I$0;
                  Pair var8 = (Pair)((<undefinedtype>)var20).L$3;
                  ApiResult var50 = (ApiResult)((<undefinedtype>)var20).L$2;
                  var51 = (DeviceG4)((<undefinedtype>)var20).L$1;
                  var68 = (BleDeviceService)((<undefinedtype>)var20).L$0;
                  ResultKt.throwOnFailure(var37);
                  var13 = (ApiResult)var37;
                  var63 = (Pair)var13.getOrNull();
                  if (var63 != null && !var13.isFailure()) {
                     var31 = 0;
                  } else {
                     var31 = 1;
                  }

                  if (var31 == 0) {
                     var15 = var63;
                     var11 = var20;
                     var12 = var68;
                     var33 = var31;
                     var88 = var51;
                     break label207;
                  }

                  var3 = var33 + 1;
                  var68 = var68;
                  var38 = var13;
               } else {
                  var33 = ((<undefinedtype>)var20).I$1;
                  int var5 = ((<undefinedtype>)var20).I$0;
                  Pair var89 = (Pair)((<undefinedtype>)var20).L$3;
                  var96 = (ApiResult)((<undefinedtype>)var20).L$2;
                  DeviceG4 var82 = (DeviceG4)((<undefinedtype>)var20).L$1;
                  BleDeviceService var77 = (BleDeviceService)((<undefinedtype>)var20).L$0;
                  ResultKt.throwOnFailure(var37);
                  Object var74 = var20;
                  var51 = var82;
                  DeviceManager var65 = this.getDeviceManager();
                  Device var22 = var82;
                  ((<undefinedtype>)var74).L$0 = var77;
                  ((<undefinedtype>)var74).L$1 = var82;
                  ((<undefinedtype>)var74).L$2 = SpillingKt.nullOutSpilledVariable(var96);
                  ((<undefinedtype>)var74).L$3 = SpillingKt.nullOutSpilledVariable(var89);
                  ((<undefinedtype>)var74).I$0 = var5;
                  ((<undefinedtype>)var74).I$1 = var33;
                  ((<undefinedtype>)var74).label = 2;
                  var68 = (BleDeviceService)var65.getRandForDevice(var22, (Continuation)var74);
                  var20 = var74;
                  if (var68 == var19) {
                     return var19;
                  }

                  var13 = (ApiResult)var68;
                  var63 = (Pair)var13.getOrNull();
                  if (var63 != null && !var13.isFailure()) {
                     var31 = 0;
                  } else {
                     var31 = 1;
                  }

                  if (var31 == 0) {
                     var15 = var63;
                     var11 = var74;
                     var12 = var77;
                     var33 = var31;
                     var88 = var51;
                     break label207;
                  }

                  var3 = var33 + 1;
                  var68 = var77;
                  var38 = var13;
               }
            } else {
               ResultKt.throwOnFailure(var37);
               Timber.Forest.d("provisionSelectedBleDevice", new Object[0]);
               var68 = this.selectedBleDeviceService;
               if (var68 == null) {
                  return Boxing.boxBoolean(false);
               }

               var51 = new DeviceG4("", (String)null, 0, (Integer)null, 0, (String)null, (String)null, (DeviceUuid)null, false, (IndoorDatapoint)null, 0, false, 0, 0L, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (double[])null, (double[])null, (double[])null, (double[])null, (double[])null, 0, false, false, false, (Boolean)null, (String)null, false, (String)null, 0, (String)null, (WelcomeHomeLocation)null, (Boolean)null, (Integer)null, (Long)null, -2, 4095, (DefaultConstructorMarker)null);
               var63 = null;
               var38 = null;
               var3 = 0;
               var31 = 0;
            }

            while(true) {
               var11 = var20;
               var12 = var68;
               var33 = var31;
               var15 = var63;
               var13 = var38;
               var88 = var51;
               if (var3 >= 2) {
                  break;
               }

               Object var75 = var20;
               var33 = var3;
               BleDeviceService var78 = var68;
               byte var36 = (byte)var31;
               Pair var90 = var63;
               var96 = var38;
               DeviceG4 var83 = var51;
               if (var3 > 0) {
                  ((<undefinedtype>)var20).L$0 = var68;
                  ((<undefinedtype>)var20).L$1 = var51;
                  ((<undefinedtype>)var20).L$2 = SpillingKt.nullOutSpilledVariable(var38);
                  ((<undefinedtype>)var20).L$3 = SpillingKt.nullOutSpilledVariable(var63);
                  ((<undefinedtype>)var20).I$0 = var31;
                  ((<undefinedtype>)var20).I$1 = var3;
                  ((<undefinedtype>)var20).label = 1;
                  var75 = var20;
                  var33 = var3;
                  var78 = var68;
                  var36 = (byte)var31;
                  var90 = var63;
                  var96 = var38;
                  var83 = var51;
                  if (DelayKt.delay(3000L, (Continuation)var20) == var19) {
                     return var19;
                  }
               }

               var51 = var83;
               DeviceManager var66 = this.getDeviceManager();
               Device var23 = var83;
               ((<undefinedtype>)var75).L$0 = var78;
               ((<undefinedtype>)var75).L$1 = var83;
               ((<undefinedtype>)var75).L$2 = SpillingKt.nullOutSpilledVariable(var96);
               ((<undefinedtype>)var75).L$3 = SpillingKt.nullOutSpilledVariable(var90);
               ((<undefinedtype>)var75).I$0 = var36;
               ((<undefinedtype>)var75).I$1 = var33;
               ((<undefinedtype>)var75).label = 2;
               var68 = (BleDeviceService)var66.getRandForDevice(var23, (Continuation)var75);
               var20 = var75;
               if (var68 == var19) {
                  return var19;
               }

               var13 = (ApiResult)var68;
               var63 = (Pair)var13.getOrNull();
               if (var63 != null && !var13.isFailure()) {
                  var31 = 0;
               } else {
                  var31 = 1;
               }

               if (var31 == 0) {
                  var15 = var63;
                  var11 = var75;
                  var12 = var78;
                  var33 = var31;
                  var88 = var51;
                  break;
               }

               var3 = var33 + 1;
               var68 = var78;
               var38 = var13;
            }
         }

         Timber.Forest var41 = Timber.Forest;
         StringBuilder var24 = new StringBuilder("provisionSelectedBleDevice: randResultValue = ");
         var24.append(var15);
         var41.d(var24.toString(), new Object[0]);
         var69 = this.getGigyaService().getBlueCloudDomain().tag();
         if (var33 != 0) {
            label78: {
               Intrinsics.checkNotNull(var13);
               Throwable var27 = var13.exceptionOrNull();
               if (var27 != null) {
                  String var47 = var27.getMessage();
                  var28 = var47;
                  if (var47 != null) {
                     break label78;
                  }
               }

               var28 = "";
            }

            this.getAnalyticsService().event(new AnalyticEvent.BT_REGISTER_ONBOARDING_ERROR(var28));
            StringBuilder var48 = new StringBuilder("Fail register for onboarding API -- ");
            var48.append(var13.exceptionOrNull());
            var12.sideLoadError(var48.toString());
            this.isRandRegisterFailed = true;
            var48 = new StringBuilder("failed: ");
            var48.append(var28);
            logStep4WifiPassword$default(this, var69, var48.toString(), "", "", "", "", (String)null, 64, (Object)null);
            return Boxing.boxBoolean(false);
         }

         this.isRandRegisterFailed = false;
         Intrinsics.checkNotNull(var15);
         this.rand = (String)var15.getFirst();
         this.text = (String)var15.getSecond();
         String var42 = this.getAuthService().getBlueHomeHost();
         String var25 = var42;
         if (StringsKt.endsWith$default(var42, "/", false, 2, (Object)null)) {
            var25 = var42.substring(0, var42.length() - 1);
            Intrinsics.checkNotNullExpressionValue(var25, "substring(...)");
         }

         String var61 = Uri.parse(this.getAuthService().getBlueHomeHost()).buildUpon().appendPath("c").appendPath("authenticate").build().toString();
         Intrinsics.checkNotNullExpressionValue(var61, "toString(...)");
         var42 = this.getAuthService().getBlueBrokerURL();
         var17 = this.getGigyaService().getBlueCloudDomain().getRegionCode();
         String var67 = this.rand;
         ProvisionConfig var105 = new ProvisionConfig(var25, var61, var42, var17, this.text, var67);
         ((<undefinedtype>)var11).L$0 = var12;
         ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var88);
         ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var15);
         ((<undefinedtype>)var11).L$4 = var69;
         ((<undefinedtype>)var11).L$5 = SpillingKt.nullOutSpilledVariable(var105);
         ((<undefinedtype>)var11).I$0 = var33;
         ((<undefinedtype>)var11).label = 3;
         Object var18 = var12.configureProvisionSync(var105, (Continuation)var11);
         if (var18 == var19) {
            return var19;
         }

         var31 = var33;
         var63 = var15;
         ApiResult var62 = var13;
         DeviceG4 var44 = var88;
         BleDeviceService var26 = var12;
         var76 = var105;
         if (!(Boolean)var18) {
            logStep4WifiPassword$default(this, var69, "success", this.getStateResult(var26, BleDeviceState.ProvisioningConfigured5.INSTANCE), "", "", "", (String)null, 64, (Object)null);
            return Boxing.boxBoolean(var6);
         }

         Ssid var91 = (Ssid)this.selectedSsid.getValue();
         String var84 = (String)var102;
         if (var91 != null) {
            var84 = var91.getSsid();
         }

         String var92 = this.password;
         Timber.Forest var99 = Timber.Forest;
         StringBuilder var103 = new StringBuilder("provisionSelectedBleDevice: ssid = ");
         var103.append(var84);
         var103.append("}, password = ");
         var103.append(var92);
         var99.d(var103.toString(), new Object[0]);
         if (var84 == null) {
            logStep4WifiPassword$default(this, var69, "success", "success", "failed: null ssid", "", "", (String)null, 64, (Object)null);
            return Boxing.boxBoolean(var6);
         }

         ((<undefinedtype>)var11).L$0 = var26;
         ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var44);
         ((<undefinedtype>)var11).L$2 = SpillingKt.nullOutSpilledVariable(var62);
         ((<undefinedtype>)var11).L$3 = SpillingKt.nullOutSpilledVariable(var63);
         ((<undefinedtype>)var11).L$4 = var69;
         ((<undefinedtype>)var11).L$5 = SpillingKt.nullOutSpilledVariable(var105);
         ((<undefinedtype>)var11).L$6 = SpillingKt.nullOutSpilledVariable(var84);
         ((<undefinedtype>)var11).L$7 = SpillingKt.nullOutSpilledVariable(var92);
         ((<undefinedtype>)var11).I$0 = var33;
         ((<undefinedtype>)var11).label = 4;
         Object var100 = var26.configureWifiSync(var84, var92, (Continuation)var11);
         if (var100 == var19) {
            return var19;
         }

         var17 = var84;
         var81 = var100;
         var102 = var11;
         var73 = var92;
         var96 = var62;
         var88 = var44;
         var53 = var26;
      }

      if (!(Boolean)var81) {
         logStep4WifiPassword$default(this, var69, "success", "success", this.getStateResult(var53, BleDeviceState.WifiConfigured.INSTANCE), "", "", (String)null, 64, (Object)null);
      } else {
         ((<undefinedtype>)var102).L$0 = var53;
         ((<undefinedtype>)var102).L$1 = SpillingKt.nullOutSpilledVariable(var88);
         ((<undefinedtype>)var102).L$2 = SpillingKt.nullOutSpilledVariable(var96);
         ((<undefinedtype>)var102).L$3 = SpillingKt.nullOutSpilledVariable(var63);
         ((<undefinedtype>)var102).L$4 = var69;
         ((<undefinedtype>)var102).L$5 = SpillingKt.nullOutSpilledVariable(var76);
         ((<undefinedtype>)var102).L$6 = SpillingKt.nullOutSpilledVariable(var17);
         ((<undefinedtype>)var102).L$7 = SpillingKt.nullOutSpilledVariable(var73);
         ((<undefinedtype>)var102).I$0 = var31;
         ((<undefinedtype>)var102).label = 5;
         Object var45 = var53.applyWifiConfigSync((Continuation)var102);
         if (var45 == var19) {
            return var19;
         }

         Boolean var46 = (Boolean)var45;
         if (!var46) {
            logStep4WifiPassword$default(this, var69, "success", "success", "success", this.getStateResult(var53, BleDeviceState.WifiConfigApplied.INSTANCE), "", (String)null, 64, (Object)null);
         }

         var6 = var46;
      }

      return Boxing.boxBoolean(var6);
   }

   public final void recordResume(String var1) {
      Intrinsics.checkNotNullParameter(var1, "screenName");
      if (!Intrinsics.areEqual(this.stayScreenName, var1)) {
         this.stayScreenName = var1;
         this.stayScreenStartTime = System.currentTimeMillis();
      }
   }

   public final void refreshSsidsList() {
      if (!(Boolean)this._isRefreshingSsids.getValue()) {
         if (!Intrinsics.areEqual(this.isSelectedBleDeviceConnected(), true)) {
            this.showConnectionLost();
         } else {
            this._isRefreshingSsids.setValue(true);
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, (Continuation)null) {
               Object L$0;
               int label;
               final AddDeviceViewModel this$0;

               {
                  this.this$0 = var1;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  MutableStateFlow var14;
                  label54: {
                     Object var3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                     int var2 = this.label;
                     Object var4;
                     if (var2 != 0) {
                        if (var2 != 1) {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var14 = (MutableStateFlow)this.L$0;
                        ResultKt.throwOnFailure(var1);
                        var4 = var1;
                     } else {
                        ResultKt.throwOnFailure(var1);
                        MutableStateFlow var8 = this.this$0._ssids;
                        BleDeviceService var5 = this.this$0.selectedBleDeviceService;
                        if (var5 == null) {
                           var14 = var8;
                           var9 = null;
                           break label54;
                        }

                        Continuation var15 = (Continuation)this;
                        this.L$0 = var8;
                        this.label = 1;
                        var4 = var5.wifiScanSync(var15);
                        if (var4 == var3) {
                           return var3;
                        }

                        var14 = var8;
                     }

                     var9 = (List)var4;
                  }

                  List var16 = var9;
                  if (var9 == null) {
                     var16 = CollectionsKt.emptyList();
                  }

                  Iterable var17 = (Iterable)var16;
                  Collection var10 = (Collection)(new ArrayList());

                  for(Object var6 : var17) {
                     Ssid var18 = (Ssid)var6;
                     CharSequence var7 = (CharSequence)var18.getSsid();
                     if (var7 != null && var7.length() != 0 && var18.getRssi() > -90) {
                        var10.add(var6);
                     }
                  }

                  Iterable var21 = (Iterable)((List)var10);
                  HashSet var11 = new HashSet();
                  ArrayList var19 = new ArrayList();

                  for(Object var22 : var21) {
                     if (var11.add(((Ssid)var22).getSsid())) {
                        var19.add(var22);
                     }
                  }

                  var14.setValue(CollectionsKt.sortedWith((Iterable)((List)var19), new Comparator(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE)) {
                     final Comparator $comparator;

                     public {
                        this.$comparator = var1;
                     }

                     public final int compare(Object var1, Object var2) {
                        Comparator var5 = this.$comparator;
                        String var4 = ((Ssid)var1).getSsid();
                        String var3 = "";
                        String var6 = var4;
                        if (var4 == null) {
                           var6 = "";
                        }

                        String var7 = ((Ssid)var2).getSsid();
                        if (var7 == null) {
                           var7 = var3;
                        }

                        return var5.compare(var6, var7);
                     }
                  }));
                  int var13 = this.this$0.wifiListRefreshCount;
                  this.this$0.wifiListRefreshCount = var13 + 1;
                  if (CollectionsKt.lastOrNull(this.this$0.logEvents) instanceof AnalyticEvent.OnboardingLogEvent.WifiList) {
                     CollectionsKt.dropLast(this.this$0.logEvents, 1);
                  }

                  AddDeviceViewModel var12 = this.this$0;
                  AddDeviceViewModel.logStep3WifiList$default(var12, var12.wifiListRefreshCount, ((List)this.this$0._ssids.getValue()).size(), (String)null, 4, (Object)null);
                  this.this$0._isRefreshingSsids.setValue(Boxing.boxBoolean(false));
                  return Unit.INSTANCE;
               }
            }, 2, (Object)null);
         }
      }
   }

   public final Object removeOwnedDevice(BluetoothDevice var1, Continuation var2) {
      label50: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var10 = var4;
               break label50;
            }
         }

         var10 = new ContinuationImpl(this, var2) {
            int I$0;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final AddDeviceViewModel this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.removeOwnedDevice((BluetoothDevice)null, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var10).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var10).label;
      HasBlueCloudFunctions var9;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var3 = ((<undefinedtype>)var10).I$0;
         var9 = (HasBlueCloudFunctions)((<undefinedtype>)var10).L$1;
         BluetoothDevice var11 = (BluetoothDevice)((<undefinedtype>)var10).L$0;
         ResultKt.throwOnFailure(var15);
      } else {
         ResultKt.throwOnFailure(var15);
         List var16 = this.onboardedDevices;
         if (var16 == null) {
            return Unit.INSTANCE;
         }

         Iterator var8 = ((Iterable)var16).iterator();

         String var6;
         String var7;
         do {
            if (!var8.hasNext()) {
               var17 = null;
               break;
            }

            var17 = var8.next();
            var7 = ((HasBlueCloudFunctions)var17).getMac().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var7, "toLowerCase(...)");
            var6 = var1.getWifiMac().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(var6, "toLowerCase(...)");
         } while(!Intrinsics.areEqual(var7, var6));

         HasBlueCloudFunctions var18 = (HasBlueCloudFunctions)var17;
         if (var18 == null) {
            return Unit.INSTANCE;
         }

         DeviceManager var20 = this.getDeviceManager();
         Device var19 = var18;
         ((<undefinedtype>)var10).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var10).L$1 = var18;
         ((<undefinedtype>)var10).I$0 = 0;
         ((<undefinedtype>)var10).label = 1;
         if (var20.removeDeviceWithLock(var19, (Continuation)var10) == var5) {
            return var5;
         }

         var9 = var18;
      }

      List var12 = this.onboardedDevices;
      if (var12 != null) {
         var12 = CollectionsKt.toMutableList((Collection)var12);
         if (var12 != null) {
            var12.remove(var9);
            this.onboardedDevices = var12;
         }
      }

      return Unit.INSTANCE;
   }

   public final void reset() {
      Timber.Forest.d("reset: selectedBleDeviceService", new Object[0]);
      this.selectedSsid.setValue((Object)null);
      this._isRefreshingSsids.setValue(false);
      this.password = "";
      this.hasSharedError = false;
      this.deselectBluetoothDevice();
      this.stopBluetoothScanning();
      this.getBleScanningService().reset();
   }

   public final void resetScanResult() {
      this.getBleScanningService().resetResult();
   }

   public final void restart() {
      this.getActionPublisher().onNext(AddDeviceAction.Restart);
   }

   public final Observable selectBluetoothDevice(BluetoothDevice var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "uiDevice");
      if (var2) {
         this.deselectBluetoothDevice();
      }

      BleDeviceService var5 = this.selectedBleDeviceService;
      android.bluetooth.BluetoothDevice var3;
      if (var5 != null) {
         var3 = var5.getCurrentDevice();
      } else {
         var3 = null;
      }

      Timber.Forest var6 = Timber.Forest;
      StringBuilder var7 = new StringBuilder("selectBluetoothDevice: old address = ");
      String var4;
      if (var3 != null) {
         var4 = var3.getAddress();
      } else {
         var4 = null;
      }

      var7.append(var4);
      var7.append(", new address = ");
      var7.append(var1.getMac());
      var6.d(var7.toString(), new Object[0]);
      if (var5 != null && var3 != null && Intrinsics.areEqual(var3.getAddress(), var1.getMac())) {
         Timber.Forest var12 = Timber.Forest;
         StringBuilder var16 = new StringBuilder("selectDevice: selected the same device ");
         var16.append(var1.getMac());
         var12.d(var16.toString(), new Object[0]);
         return var5.getDeviceStateObserver();
      } else {
         this.deselectBluetoothDevice();
         BleScannedDevice var13 = this.getBleScanningService().getScannedDevice(var1.getMac());
         Timber.Forest var17 = Timber.Forest;
         StringBuilder var9 = new StringBuilder("selectBluetoothDevice: scanDevice = ");
         var9.append(var13);
         var17.d(var9.toString(), new Object[0]);
         if (var13 != null) {
            BleDeviceService var11 = new BleDeviceService(var13.getDevice(), var13.getServiceUuid(), (Context)this.getApplication(), this.getAnalyticsService());
            this.selectedBleDeviceService = var11;
            this.selectedUiDevice = var1;
            Timber.Forest var8 = Timber.Forest;
            StringBuilder var15 = new StringBuilder("selectBluetoothDevice: new selectedBleDeviceService = ");
            var15.append(this.selectedBleDeviceService);
            var8.d(var15.toString(), new Object[0]);
            return var11.getDeviceStateObserver();
         } else {
            Timber.Forest var14 = Timber.Forest;
            var9 = new StringBuilder("selectDevice: selected device ");
            var9.append(var1.getMac());
            var9.append(" NOT FOUND");
            var14.w(var9.toString(), new Object[0]);
            return null;
         }
      }
   }

   public final void setDeviceName(String var1) {
      Intrinsics.checkNotNullParameter(var1, "nuName");
      this._selectedDeviceName.setValue(var1);
   }

   public final void setHasSharedError(boolean var1) {
      this.hasSharedError = var1;
   }

   public final void setHiddenNetwork(boolean var1) {
      this.isHiddenNetwork = var1;
   }

   public final void setPassword$adddevice_otherRelease(String var1) {
      this.password = var1;
   }

   public final void setPolling(boolean var1) {
      this.polling = var1;
   }

   public final void setRand(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.rand = var1;
   }

   public final void setSelectedSsid(MutableLiveData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.selectedSsid = var1;
   }

   public final void setText(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.text = var1;
   }

   public final void showConnectionLost() {
      this.getActionPublisher().onNext(AddDeviceAction.ShowConnectionLost);
   }

   public final void startBluetoothScanning() {
      Timber.Forest.d("startBluetoothScanning", new Object[0]);
      this.getBleScanningService().startScanning();
   }

   public final void stopBluetoothScanning() {
      Timber.Forest.d("stopBluetoothScanning", new Object[0]);
      this.getBleScanningService().stopScanning();
   }

   public final void unbindNetwork(Activity var1) {
      Intrinsics.checkNotNullParameter(var1, "activity");
      Object var2 = var1.getSystemService("connectivity");
      Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type android.net.ConnectivityManager");
      ((ConnectivityManager)var2).bindProcessToNetwork((Network)null);
   }

   @Metadata(
      d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"},
      d2 = {"Lcom/blueair/adddevice/viewmodel/AddDeviceViewModel$Companion;", "", "<init>", "()V", "MAX_PROVISION_ATTEMPTS", "", "adddevice_otherRelease"},
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
   }
}
