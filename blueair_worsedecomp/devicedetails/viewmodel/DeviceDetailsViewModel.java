package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.format.DateFormat;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.auth.AuthService;
import com.blueair.auth.LocationService;
import com.blueair.core.PrefKeys;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceAware;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceType;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.Filter;
import com.blueair.core.model.FilterTrigger;
import com.blueair.core.model.HasAirRefresh;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.core.util.LinkUtils;
import com.blueair.core.util.NetworkMonitor;
import com.blueair.core.util.PhoneUtil;
import com.blueair.devicedetails.util.DeviceAttribute;
import com.blueair.outdoor.service.OutdoorService;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.kodein.di.DIAware;
import org.kodein.di.DIAwareKt;
import org.kodein.di.LazyDelegate;
import org.kodein.type.GenericJVMTypeTokenDelegate;
import org.kodein.type.JVMTypeToken;
import org.kodein.type.TypeTokensJVMKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0013\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u0001\u001a\u00030\u00012\u001b\u0010\u0001\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+\u0012\u0005\u0012\u00030\u00010\u0001J\b\u0010\u0001\u001a\u00030\u0001J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u001e\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001JR\u0010\u0001\u001a\u00030\u0001\"\u000b\b\u0000\u0010 \u0001\u0018\u0001*\u00020,2\u0006\u0010D\u001a\u00020,2*\b\u0004\u0010¡\u0001\u001a#\b\u0001\u0012\u0005\u0012\u0003H \u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010£\u0001\u0012\u0007\u0012\u0005\u0018\u00010¤\u00010¢\u0001H\b¢\u0006\u0003\u0010¥\u0001J\u001a\u0010¦\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010§\u0001\u001a\u00030¨\u0001J\u0019\u0010©\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010ª\u0001\u001a\u000205J\u0010\u0010«\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010¬\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010­\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010®\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u001a\u0010¯\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010°\u0001\u001a\u00030±\u0001J\u001a\u0010¯\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010°\u0001\u001a\u00030²\u0001J\u0010\u0010³\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010´\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u001a\u0010µ\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010¶\u0001\u001a\u00030²\u0001J\u001a\u0010·\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010¸\u0001\u001a\u00030²\u0001J\u001a\u0010¹\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010º\u0001\u001a\u00030²\u0001J\u001a\u0010»\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010º\u0001\u001a\u00030²\u0001J\u0010\u0010¼\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010½\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010¾\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010¿\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010À\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J.\u0010Á\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Â\u0001\u001a\u00030²\u00012\b\u0010Ã\u0001\u001a\u00030²\u00012\b\u0010Ä\u0001\u001a\u00030²\u0001J\u0010\u0010Å\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010Æ\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J$\u0010Ç\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u00012\t\b\u0002\u0010È\u0001\u001a\u000205J\u0019\u0010É\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010Ê\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010Ë\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010Ì\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Í\u0001J\u0019\u0010Î\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030Í\u0001J\u0019\u0010Ï\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010Ð\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J&\u0010Ñ\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ò\u0001\u001a\u00030²\u00012\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001J&\u0010Õ\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010Ò\u0001\u001a\u00030²\u00012\n\u0010Ó\u0001\u001a\u0005\u0018\u00010Ô\u0001J\u0010\u0010Ö\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010×\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010Ø\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0010\u0010Ù\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010Ú\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010Û\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0010\u0010Ü\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010Ý\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0010\u0010Þ\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010ß\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010à\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010á\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0019\u0010â\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u001a\u0010ã\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010º\u0001\u001a\u00030²\u0001J\u0018\u0010ä\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0006\u0010?\u001a\u000205Ja\u0010å\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010æ\u0001\u001a\u00030²\u00012\n\u0010ç\u0001\u001a\u0005\u0018\u00010è\u000123\b\u0002\u0010\u0001\u001a,\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030ê\u00010é\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u00030\u00010£\u0001\u0012\u0007\u0012\u0005\u0018\u00010¤\u0001\u0018\u00010¢\u0001¢\u0006\u0003\u0010ë\u0001J$\u0010ì\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010í\u0001\u001a\u00030²\u00012\b\u0010î\u0001\u001a\u00030²\u0001J\u0010\u0010ï\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010ð\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010?\u001a\u00030²\u0001J\u0018\u0010ñ\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0006\u0010?\u001a\u000205J\u0010\u0010ò\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010ó\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0012\u0010ô\u0001\u001a\u00030\u00012\b\u0010õ\u0001\u001a\u00030ö\u0001J\u001c\u0010ô\u0001\u001a\u00030\u00012\b\u0010÷\u0001\u001a\u00030ö\u00012\b\u0010ø\u0001\u001a\u00030ö\u0001J#\u0010ù\u0001\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010ú\u0001\u001a\u00030û\u0001H@¢\u0006\u0003\u0010ü\u0001J\u0011\u0010ý\u0001\u001a\u0002052\b\u0010D\u001a\u0004\u0018\u00010,J\u001a\u0010\u0002\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\b\u0010\u0002\u001a\u00030\u0002J@\u0010\u0002\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010\u0002\u001a\u0002052\u0007\u0010\u0002\u001a\u0002052\b\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020:2\t\b\u0002\u0010\u0002\u001a\u000205J$\u0010\u0002\u001a\u00030\u00012\b\u0010\u0002\u001a\u00030\u00022\u0007\u0010\u0002\u001a\u00020:2\u0007\u0010\u0002\u001a\u00020:J\u0007\u0010\u0002\u001a\u000205J\u0007\u0010\u0002\u001a\u00020:J\u0019\u0010\u0002\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,2\u0007\u0010\u0002\u001a\u00020:J\u0010\u0010\u0002\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,J\u0019\u0010\u0002\u001a\u00030\u00012\u0006\u0010D\u001a\u00020,H@¢\u0006\u0003\u0010\u0002J\b\u0010\u0002\u001a\u00030\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010 \u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001b\u0010$\u001a\u00020%8FX\u0002¢\u0006\f\n\u0004\b(\u0010\u000b\u001a\u0004\b&\u0010'R\u001d\u0010)\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0+0*¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u0002000*8F¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020003X\u0004¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u00020:2\u0006\u0010?\u001a\u00020:@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010<\"\u0004\bB\u0010>R/\u0010D\u001a\u0004\u0018\u00010,2\b\u0010C\u001a\u0004\u0018\u00010,8F@FX\u0002¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010K\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L03X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010L0*¢\u0006\b\n\u0000\u001a\u0004\bN\u0010.R\u0019\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0*8F¢\u0006\u0006\u001a\u0004\bP\u0010.R\u0017\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0*8F¢\u0006\u0006\u001a\u0004\bS\u0010.R+\u0010U\u001a\u00020T2\u0006\u0010C\u001a\u00020T8B@BX\u0002¢\u0006\u0012\n\u0004\bZ\u0010J\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR+\u0010\\\u001a\u00020[2\u0006\u0010C\u001a\u00020[8B@BX\u0002¢\u0006\u0012\n\u0004\ba\u0010J\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R/\u0010c\u001a\u0004\u0018\u00010b2\b\u0010C\u001a\u0004\u0018\u00010b8F@FX\u0002¢\u0006\u0012\n\u0004\bh\u0010J\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0014\u0010i\u001a\b\u0012\u0004\u0012\u00020503X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010j\u001a\b\u0012\u0004\u0012\u0002050*8F¢\u0006\u0006\u001a\u0004\bk\u0010.R\u0014\u0010l\u001a\b\u0012\u0004\u0012\u00020503X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010m\u001a\b\u0012\u0004\u0012\u0002050*¢\u0006\b\n\u0000\u001a\u0004\bn\u0010.R\u001a\u0010o\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bp\u00106\"\u0004\bq\u00108R\u001a\u0010r\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u00106\"\u0004\bt\u00108R\u001a\u0010u\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u00106\"\u0004\bw\u00108R\u001a\u0010x\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u00106\"\u0004\bz\u00108R\u000e\u0010{\u001a\u00020|X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010}\u001a\u000205X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010~\u001a\b\u0012\u0004\u0012\u00020503X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u001a\b\u0012\u0004\u0012\u0002050*¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010.R'\u0010\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u00106\"\u0005\b\u0001\u00108R'\u0010\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u00106\"\u0005\b\u0001\u00108R'\u0010\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u00106\"\u0005\b\u0001\u00108R'\u0010\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u00106\"\u0005\b\u0001\u00108R'\u0010\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u00106\"\u0005\b\u0001\u00108R'\u0010\u0001\u001a\u0002052\u0006\u0010?\u001a\u0002058F@FX\u000e¢\u0006\u000e\u001a\u0005\b\u0001\u00106\"\u0005\b\u0001\u00108R\u0016\u0010þ\u0001\u001a\t\u0012\u0005\u0012\u00030ÿ\u000103X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\t\u0012\u0005\u0012\u00030ÿ\u00010*¢\u0006\t\n\u0000\u001a\u0005\b\u0002\u0010.¨\u0006\u0002"}, d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceDetailsViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "authService", "Lcom/blueair/auth/AuthService;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "authService$delegate", "Lkotlin/Lazy;", "locationService", "Lcom/blueair/auth/LocationService;", "getLocationService", "()Lcom/blueair/auth/LocationService;", "locationService$delegate", "outdoorService", "Lcom/blueair/outdoor/service/OutdoorService;", "getOutdoorService", "()Lcom/blueair/outdoor/service/OutdoorService;", "outdoorService$delegate", "networkMonitor", "Lcom/blueair/core/util/NetworkMonitor;", "getNetworkMonitor", "()Lcom/blueair/core/util/NetworkMonitor;", "networkMonitor$delegate", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "mapType", "Lcom/blueair/auth/LocationService$MapType;", "getMapType", "()Lcom/blueair/auth/LocationService$MapType;", "currentTimeFormatter", "Ljava/text/SimpleDateFormat;", "getCurrentTimeFormatter", "()Ljava/text/SimpleDateFormat;", "currentTimeFormatter$delegate", "liveDevices", "Landroidx/lifecycle/LiveData;", "", "Lcom/blueair/core/model/Device;", "getLiveDevices", "()Landroidx/lifecycle/LiveData;", "deviceDetailsState", "Lcom/blueair/devicedetails/viewmodel/DeviceDetailsState;", "getDeviceDetailsState", "_deviceDetailsState", "Landroidx/lifecycle/MutableLiveData;", "isAttachedToDeviceDetailsDialogFragment", "", "()Z", "setAttachedToDeviceDetailsDialogFragment", "(Z)V", "actionType", "", "getActionType", "()Ljava/lang/String;", "setActionType", "(Ljava/lang/String;)V", "value", "deviceId", "getDeviceId", "setDeviceId", "<set-?>", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "device$delegate", "Lkotlin/properties/ReadWriteProperty;", "_liveLocation", "Lcom/blueair/core/model/TrackedLocation;", "liveLocation", "getLiveLocation", "liveDevice", "getLiveDevice", "liveLatestDataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getLiveLatestDataPoint", "Lcom/blueair/core/model/SensorType;", "selectedSensorType", "getSelectedSensorType", "()Lcom/blueair/core/model/SensorType;", "setSelectedSensorType", "(Lcom/blueair/core/model/SensorType;)V", "selectedSensorType$delegate", "Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "selectedSettingsType", "getSelectedSettingsType", "()Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", "setSelectedSettingsType", "(Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;)V", "selectedSettingsType$delegate", "Lcom/blueair/core/model/DeviceData;", "deviceData", "getDeviceData", "()Lcom/blueair/core/model/DeviceData;", "setDeviceData", "(Lcom/blueair/core/model/DeviceData;)V", "deviceData$delegate", "_networkAvailable", "networkAvailable", "getNetworkAvailable", "_deviceOffline", "deviceOffline", "getDeviceOffline", "bannerBodyNotMountedClosed", "getBannerBodyNotMountedClosed", "setBannerBodyNotMountedClosed", "bannerFilterExpiredClosed", "getBannerFilterExpiredClosed", "setBannerFilterExpiredClosed", "bannerWickExpiredClosed", "getBannerWickExpiredClosed", "setBannerWickExpiredClosed", "bannerWaterShortageClosed", "getBannerWaterShortageClosed", "setBannerWaterShortageClosed", "lastFilterPurchaseClickTime", "", "autoModeClickedBefore", "_autoModeFirstClicked", "autoModeFirstClicked", "getAutoModeFirstClicked", "autoRefreshHintClosedBefore", "getAutoRefreshHintClosedBefore", "setAutoRefreshHintClosedBefore", "controlsHintClosedBefore", "getControlsHintClosedBefore", "setControlsHintClosedBefore", "humHintClosedBefore", "getHumHintClosedBefore", "setHumHintClosedBefore", "skinHintClosedBefore", "getSkinHintClosedBefore", "setSkinHintClosedBefore", "smartHintClosedBefore", "getSmartHintClosedBefore", "setSmartHintClosedBefore", "sunRiseLightHintClosedBefore", "getSunRiseLightHintClosedBefore", "setSunRiseLightHintClosedBefore", "getDevices", "", "onResult", "Lkotlin/Function1;", "updateEverything", "updateState", "linkDeviceSelected", "Lkotlinx/coroutines/Job;", "parentDevice", "Lcom/blueair/core/model/HasLinkingCapability;", "linkedDevice", "Lcom/blueair/core/model/DeviceAware;", "setActuator", "T", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/blueair/core/model/Device;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "fanspeedSliderChanged", "nuFanSpeedEnum", "Lcom/blueair/core/model/FanSpeedEnum;", "autoModeChanged", "nuMode", "setManualMode", "standByChanged", "ecoModeChanged", "g4NightModeChanged", "brightnessChanged", "brightness", "Lcom/blueair/core/model/Brightness;", "", "wickDryCanceled", "wickDryEnabledChanged", "autorhChanged", "autorh", "timerStatusChanged", "status", "timerDurationChanged", "duration", "updateTimerDurationAndRestart", "childLockChanged", "germShieldChanged", "disinfectionChanged", "gsnmChanged", "oscillationStateChanged", "setOscillationParams", "angle", "direction", "fanSpeed", "temperatureUnitChanged", "setMainMode", "setApSubMode", "overwriteMainMode", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolAutoPresets", "tag", "presets", "", "setCoolEcoPresets", "hinsModeChanged", "hinsNightModeChanged", "setMode", "humModeChanged", "setDehSubMode", "setSmartSubMode", "setTare", "setPanelDisplayMode", "hoverEnabledChanged", "setAutoRefreshStatus", "setNightLampBrightness", "setNightLampSteplessBrightness", "setWickDryDuration", "updateWickDryDurationAndRestart", "setYwrmEnabled", "setAlarm", "index", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "(Lcom/blueair/core/model/Device;ILcom/blueair/core/model/DeviceAlarm;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "playAlarm", "sound", "volume", "stopAlarm", "setHumSubMode", "setUse24Hour", "autoRefreshEnabledChanged", "sensorModeChange", "autoModeFilterTriggerChanged", "nuFilterTrigger", "Lcom/blueair/core/model/FilterTrigger;", "nuAutoModeFilterTrigger", "nuG4NightModeFilterTrigger", "setFilter", "nuFilter", "Lcom/blueair/core/model/Filter;", "(Lcom/blueair/core/model/Device;Lcom/blueair/core/model/Filter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceSupportAntiFake", "_resetFilterLifeResult", "Lcom/blueair/devicedetails/viewmodel/FilterLifeResetResult;", "resetFilterLifeResult", "getResetFilterLifeResult", "resetFilterLife", "type", "Lcom/blueair/core/model/DeviceFilterType;", "analyticsLogFilterClickEvent", "isPurchase", "isSelect", "filterType", "filterName", "fromNotification", "openFilterUrl", "context", "Landroid/content/Context;", "url", "title", "isInWelcomeHomeRegion", "getWarrantyLink", "setDeviceName", "nuName", "removeDevice", "removeDeviceWithLock", "(Lcom/blueair/core/model/Device;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureUseProtectRegion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceDetailsViewModel.kt */
public final class DeviceDetailsViewModel extends BaseViewModel {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _autoModeFirstClicked;
    private final MutableLiveData<DeviceDetailsState> _deviceDetailsState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _deviceOffline;
    /* access modifiers changed from: private */
    public final MutableLiveData<TrackedLocation> _liveLocation;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _networkAvailable;
    /* access modifiers changed from: private */
    public final MutableLiveData<FilterLifeResetResult> _resetFilterLifeResult;
    private String actionType;
    private final Lazy authService$delegate;
    /* access modifiers changed from: private */
    public boolean autoModeClickedBefore;
    private final LiveData<Boolean> autoModeFirstClicked;
    private boolean bannerBodyNotMountedClosed;
    private boolean bannerFilterExpiredClosed;
    private boolean bannerWaterShortageClosed;
    private boolean bannerWickExpiredClosed;
    private final Lazy currentTimeFormatter$delegate;
    private final ReadWriteProperty device$delegate;
    private final ReadWriteProperty deviceData$delegate;
    private String deviceId = "";
    private final LiveData<Boolean> deviceOffline;
    private boolean isAttachedToDeviceDetailsDialogFragment;
    private long lastFilterPurchaseClickTime;
    private final LiveData<List<Device>> liveDevices = getDeviceManager().getLiveDevices();
    private final LiveData<TrackedLocation> liveLocation;
    private final Lazy locationService$delegate;
    private final Lazy networkMonitor$delegate;
    private final Lazy outdoorService$delegate;
    private final Lazy prefs$delegate;
    private final LiveData<FilterLifeResetResult> resetFilterLifeResult;
    private final ReadWriteProperty selectedSensorType$delegate;
    private final ReadWriteProperty selectedSettingsType$delegate;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceDetailsViewModel.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            /*
                com.blueair.devicedetails.viewmodel.DeviceSettingsType[] r0 = com.blueair.devicedetails.viewmodel.DeviceSettingsType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.devicedetails.viewmodel.DeviceSettingsType r1 = com.blueair.devicedetails.viewmodel.DeviceSettingsType.Fanspeed     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.devicedetails.viewmodel.DeviceSettingsType r1 = com.blueair.devicedetails.viewmodel.DeviceSettingsType.Brightness     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.devicedetails.viewmodel.DeviceSettingsType r1 = com.blueair.devicedetails.viewmodel.DeviceSettingsType.Childlock     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.devicedetails.viewmodel.DeviceSettingsType r1 = com.blueair.devicedetails.viewmodel.DeviceSettingsType.Nightmode     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.devicedetails.viewmodel.DeviceSettingsType r1 = com.blueair.devicedetails.viewmodel.DeviceSettingsType.Linking     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel.WhenMappings.<clinit>():void");
        }
    }

    static {
        Class<DeviceDetailsViewModel> cls = DeviceDetailsViewModel.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "authService", "getAuthService()Lcom/blueair/auth/AuthService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "locationService", "getLocationService()Lcom/blueair/auth/LocationService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "outdoorService", "getOutdoorService()Lcom/blueair/outdoor/service/OutdoorService;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "networkMonitor", "getNetworkMonitor()Lcom/blueair/core/util/NetworkMonitor;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "device", "getDevice()Lcom/blueair/core/model/Device;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedSensorType", "getSelectedSensorType()Lcom/blueair/core/model/SensorType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "selectedSettingsType", "getSelectedSettingsType()Lcom/blueair/devicedetails/viewmodel/DeviceSettingsType;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(cls, "deviceData", "getDeviceData()Lcom/blueair/core/model/DeviceData;", 0))};
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DIAware dIAware = this;
        JVMTypeToken<?> typeToken = TypeTokensJVMKt.typeToken(new DeviceDetailsViewModel$special$$inlined$instance$default$1().getSuperType());
        Intrinsics.checkNotNull(typeToken, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        LazyDelegate Instance = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken, AuthService.class), (Object) null);
        KProperty<Object>[] kPropertyArr = $$delegatedProperties;
        this.authService$delegate = Instance.provideDelegate(this, kPropertyArr[0]);
        JVMTypeToken<?> typeToken2 = TypeTokensJVMKt.typeToken(new DeviceDetailsViewModel$special$$inlined$instance$default$2().getSuperType());
        Intrinsics.checkNotNull(typeToken2, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.locationService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken2, LocationService.class), (Object) null).provideDelegate(this, kPropertyArr[1]);
        JVMTypeToken<?> typeToken3 = TypeTokensJVMKt.typeToken(new DeviceDetailsViewModel$special$$inlined$instance$default$3().getSuperType());
        Intrinsics.checkNotNull(typeToken3, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.outdoorService$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken3, OutdoorService.class), (Object) null).provideDelegate(this, kPropertyArr[2]);
        JVMTypeToken<?> typeToken4 = TypeTokensJVMKt.typeToken(new DeviceDetailsViewModel$special$$inlined$instance$default$4().getSuperType());
        Intrinsics.checkNotNull(typeToken4, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.networkMonitor$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken4, NetworkMonitor.class), (Object) null).provideDelegate(this, kPropertyArr[3]);
        JVMTypeToken<?> typeToken5 = TypeTokensJVMKt.typeToken(new DeviceDetailsViewModel$special$$inlined$instance$default$5().getSuperType());
        Intrinsics.checkNotNull(typeToken5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
        this.prefs$delegate = DIAwareKt.Instance(dIAware, new GenericJVMTypeTokenDelegate(typeToken5, UnsecurePrefs.class), (Object) null).provideDelegate(this, kPropertyArr[4]);
        this.currentTimeFormatter$delegate = LazyKt.lazy(new DeviceDetailsViewModel$$ExternalSyntheticLambda0(application));
        Delegates delegates = Delegates.INSTANCE;
        this.device$delegate = new DeviceDetailsViewModel$special$$inlined$observable$1((Object) null, this);
        MutableLiveData<TrackedLocation> mutableLiveData = new MutableLiveData<>();
        this._liveLocation = mutableLiveData;
        this.liveLocation = Transformations.distinctUntilChanged(mutableLiveData);
        Delegates delegates2 = Delegates.INSTANCE;
        this.selectedSensorType$delegate = new DeviceDetailsViewModel$special$$inlined$observable$2(SensorType.PM25, this);
        Delegates delegates3 = Delegates.INSTANCE;
        this.selectedSettingsType$delegate = new DeviceDetailsViewModel$special$$inlined$observable$3(DeviceSettingsType.Fanspeed, this);
        Delegates delegates4 = Delegates.INSTANCE;
        this.deviceData$delegate = new DeviceDetailsViewModel$special$$inlined$observable$4((Object) null, this);
        this._networkAvailable = new MutableLiveData<>();
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>();
        this._deviceOffline = mutableLiveData2;
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(getNetworkAvailable(), new DeviceDetailsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceDetailsViewModel$$ExternalSyntheticLambda1(mediatorLiveData, this)));
        mediatorLiveData.addSource(mutableLiveData2, new DeviceDetailsViewModel$sam$androidx_lifecycle_Observer$0(new DeviceDetailsViewModel$$ExternalSyntheticLambda2(mediatorLiveData, this)));
        this.deviceOffline = mediatorLiveData;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(false);
        this._autoModeFirstClicked = mutableLiveData3;
        this.autoModeFirstClicked = mutableLiveData3;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        DeviceAttribute.Companion.setShowDetectCat(((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), PrefKeys.KEY_SHOW_DETECT_CAT, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue());
        MutableLiveData<FilterLifeResetResult> mutableLiveData4 = new MutableLiveData<>(null);
        this._resetFilterLifeResult = mutableLiveData4;
        this.resetFilterLifeResult = mutableLiveData4;
    }

    private final AuthService getAuthService() {
        return (AuthService) this.authService$delegate.getValue();
    }

    private final LocationService getLocationService() {
        return (LocationService) this.locationService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final OutdoorService getOutdoorService() {
        return (OutdoorService) this.outdoorService$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final NetworkMonitor getNetworkMonitor() {
        return (NetworkMonitor) this.networkMonitor$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final UnsecurePrefs getPrefs() {
        return (UnsecurePrefs) this.prefs$delegate.getValue();
    }

    public final LocationService.MapType getMapType() {
        return getLocationService().getMapType();
    }

    public final SimpleDateFormat getCurrentTimeFormatter() {
        return (SimpleDateFormat) this.currentTimeFormatter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat currentTimeFormatter_delegate$lambda$0(Application application) {
        return new SimpleDateFormat(DateFormat.is24HourFormat(application) ? "HH:mm" : "hh:mm a");
    }

    public final LiveData<List<Device>> getLiveDevices() {
        return this.liveDevices;
    }

    public final LiveData<DeviceDetailsState> getDeviceDetailsState() {
        return this._deviceDetailsState;
    }

    public final boolean isAttachedToDeviceDetailsDialogFragment() {
        return this.isAttachedToDeviceDetailsDialogFragment;
    }

    public final void setAttachedToDeviceDetailsDialogFragment(boolean z) {
        this.isAttachedToDeviceDetailsDialogFragment = z;
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final void setActionType(String str) {
        this.actionType = str;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        Timber.Forest forest = Timber.Forest;
        forest.d("device id new value: " + str, new Object[0]);
        boolean z = !Intrinsics.areEqual((Object) this.deviceId, (Object) str) && str.length() > 0;
        this.deviceId = str;
        String format = String.format(PrefKeys.KEY_AUTO_MODE_CLICKED_BEFORE, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        this.autoModeClickedBefore = ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
        if (z) {
            updateEverything();
        }
    }

    public final Device getDevice() {
        return (Device) this.device$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final void setDevice(Device device) {
        this.device$delegate.setValue(this, $$delegatedProperties[5], device);
    }

    public final LiveData<TrackedLocation> getLiveLocation() {
        return this.liveLocation;
    }

    public final LiveData<Device> getLiveDevice() {
        return getDeviceManager().databaseDevice(this.deviceId);
    }

    public final LiveData<IndoorDatapoint> getLiveLatestDataPoint() {
        return FlowLiveDataConversions.asLiveData$default((Flow) FlowKt.distinctUntilChanged(getDeviceManager().getFlowLatestDatapoint(this.deviceId)), ViewModelKt.getViewModelScope(this).getCoroutineContext().plus(Dispatchers.getIO()), 0, 2, (Object) null);
    }

    private final SensorType getSelectedSensorType() {
        return (SensorType) this.selectedSensorType$delegate.getValue(this, $$delegatedProperties[6]);
    }

    private final void setSelectedSensorType(SensorType sensorType) {
        this.selectedSensorType$delegate.setValue(this, $$delegatedProperties[6], sensorType);
    }

    private final DeviceSettingsType getSelectedSettingsType() {
        return (DeviceSettingsType) this.selectedSettingsType$delegate.getValue(this, $$delegatedProperties[7]);
    }

    private final void setSelectedSettingsType(DeviceSettingsType deviceSettingsType) {
        this.selectedSettingsType$delegate.setValue(this, $$delegatedProperties[7], deviceSettingsType);
    }

    public final DeviceData getDeviceData() {
        return (DeviceData) this.deviceData$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final void setDeviceData(DeviceData deviceData) {
        this.deviceData$delegate.setValue(this, $$delegatedProperties[8], deviceData);
    }

    public final LiveData<Boolean> getNetworkAvailable() {
        return this._networkAvailable;
    }

    public final LiveData<Boolean> getDeviceOffline() {
        return this.deviceOffline;
    }

    /* access modifiers changed from: private */
    public static final Unit deviceOffline$lambda$8$lambda$6(MediatorLiveData mediatorLiveData, DeviceDetailsViewModel deviceDetailsViewModel, Boolean bool) {
        boolean z = true;
        if (bool.booleanValue() && !Intrinsics.areEqual((Object) deviceDetailsViewModel._deviceOffline.getValue(), (Object) true)) {
            z = false;
        }
        mediatorLiveData.postValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit deviceOffline$lambda$8$lambda$7(MediatorLiveData mediatorLiveData, DeviceDetailsViewModel deviceDetailsViewModel, Boolean bool) {
        boolean z = false;
        if (Intrinsics.areEqual((Object) deviceDetailsViewModel.getNetworkAvailable().getValue(), (Object) false) || bool.booleanValue()) {
            z = true;
        }
        mediatorLiveData.postValue(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    public final boolean getBannerBodyNotMountedClosed() {
        return this.bannerBodyNotMountedClosed;
    }

    public final void setBannerBodyNotMountedClosed(boolean z) {
        this.bannerBodyNotMountedClosed = z;
    }

    public final boolean getBannerFilterExpiredClosed() {
        return this.bannerFilterExpiredClosed;
    }

    public final void setBannerFilterExpiredClosed(boolean z) {
        this.bannerFilterExpiredClosed = z;
    }

    public final boolean getBannerWickExpiredClosed() {
        return this.bannerWickExpiredClosed;
    }

    public final void setBannerWickExpiredClosed(boolean z) {
        this.bannerWickExpiredClosed = z;
    }

    public final boolean getBannerWaterShortageClosed() {
        return this.bannerWaterShortageClosed;
    }

    public final void setBannerWaterShortageClosed(boolean z) {
        this.bannerWaterShortageClosed = z;
    }

    public final LiveData<Boolean> getAutoModeFirstClicked() {
        return this.autoModeFirstClicked;
    }

    public final boolean getAutoRefreshHintClosedBefore() {
        String format = String.format(PrefKeys.KEY_AUTO_REFRESH_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setAutoRefreshHintClosedBefore(boolean z) {
        String format = String.format(PrefKeys.KEY_AUTO_REFRESH_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public final boolean getControlsHintClosedBefore() {
        String format = String.format(PrefKeys.KEY_CONTROLS_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setControlsHintClosedBefore(boolean z) {
        String format = String.format(PrefKeys.KEY_CONTROLS_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public final boolean getHumHintClosedBefore() {
        String format = String.format(PrefKeys.KEY_HUM_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setHumHintClosedBefore(boolean z) {
        String format = String.format(PrefKeys.KEY_HUM_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public final boolean getSkinHintClosedBefore() {
        String format = String.format(PrefKeys.KEY_SKIN_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setSkinHintClosedBefore(boolean z) {
        String format = String.format(PrefKeys.KEY_SKIN_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public final boolean getSmartHintClosedBefore() {
        String format = String.format(PrefKeys.KEY_SMART_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setSmartHintClosedBefore(boolean z) {
        String format = String.format(PrefKeys.KEY_SMART_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    public final boolean getSunRiseLightHintClosedBefore() {
        String format = String.format(PrefKeys.KEY_SUNRISE_LIGHT_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return ((Boolean) PreferencesHelper.INSTANCE.get(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class))).booleanValue();
    }

    public final void setSunRiseLightHintClosedBefore(boolean z) {
        String format = String.format(PrefKeys.KEY_SUNRISE_LIGHT_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{this.deviceId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, Boolean.valueOf(z), Reflection.getOrCreateKotlinClass(Boolean.class));
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$1", f = "DeviceDetailsViewModel.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$1  reason: invalid class name */
    /* compiled from: DeviceDetailsViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DeviceDetailsViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<Boolean> connectivityStatus = this.this$0.getNetworkMonitor().getConnectivityStatus();
                final DeviceDetailsViewModel deviceDetailsViewModel = this.this$0;
                this.label = 1;
                if (connectivityStatus.collect(new FlowCollector() {
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                        deviceDetailsViewModel._networkAvailable.postValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final void getDevices(Function1<? super List<? extends Device>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onResult");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$getDevices$1(this, function1, (Continuation<? super DeviceDetailsViewModel$getDevices$1>) null), 2, (Object) null);
    }

    public final void updateEverything() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$updateEverything$1(this, (Continuation<? super DeviceDetailsViewModel$updateEverything$1>) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0061, code lost:
        r5 = r5.valueFor(getSelectedSensorType());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateState() {
        /*
            r10 = this;
            com.blueair.core.model.Device r2 = r10.getDevice()
            if (r2 == 0) goto L_0x008f
            boolean r1 = r2 instanceof com.blueair.core.model.HasSensorData
            com.blueair.core.model.DeviceData r0 = r10.getDeviceData()
            r3 = 0
            r4 = 2
            if (r0 == 0) goto L_0x001b
            com.blueair.core.model.SensorType r5 = r10.getSelectedSensorType()
            r6 = 0
            java.util.List r0 = com.blueair.core.model.DeviceData.toSimpleDataPoints$default(r0, r5, r6, r4, r3)
            if (r0 != 0) goto L_0x001f
        L_0x001b:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L_0x001f:
            com.blueair.devicedetails.viewmodel.DeviceSettingsType r5 = r10.getSelectedSettingsType()
            int[] r6 = com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel.WhenMappings.$EnumSwitchMapping$0
            int r5 = r5.ordinal()
            r5 = r6[r5]
            r6 = 1
            if (r5 == r6) goto L_0x004b
            if (r5 == r4) goto L_0x0048
            r4 = 3
            if (r5 == r4) goto L_0x0045
            r4 = 4
            if (r5 == r4) goto L_0x0042
            r4 = 5
            if (r5 != r4) goto L_0x003c
            int r4 = com.blueair.viewcore.R.string.link_title
            goto L_0x004d
        L_0x003c:
            kotlin.NoWhenBranchMatchedException r0 = new kotlin.NoWhenBranchMatchedException
            r0.<init>()
            throw r0
        L_0x0042:
            int r4 = com.blueair.viewcore.R.string.nightmode_title
            goto L_0x004d
        L_0x0045:
            int r4 = com.blueair.viewcore.R.string.childlock_title
            goto L_0x004d
        L_0x0048:
            int r4 = com.blueair.viewcore.R.string.brightness_title
            goto L_0x004d
        L_0x004b:
            int r4 = com.blueair.viewcore.R.string.fan_title
        L_0x004d:
            r7 = r4
            if (r1 == 0) goto L_0x007a
            r4 = r2
            com.blueair.core.model.HasSensorData r4 = (com.blueair.core.model.HasSensorData) r4
            com.blueair.core.model.IndoorDatapoint r5 = r4.getLatestSensorDatapoint()
            if (r5 == 0) goto L_0x007a
            com.blueair.viewcore.view.StatusLabelState$Companion r3 = com.blueair.viewcore.view.StatusLabelState.Companion
            com.blueair.core.model.IndoorDatapoint r5 = r4.getLatestSensorDatapoint()
            if (r5 == 0) goto L_0x0070
            com.blueair.core.model.SensorType r6 = r10.getSelectedSensorType()
            java.lang.Float r5 = r5.valueFor(r6)
            if (r5 == 0) goto L_0x0070
            float r5 = r5.floatValue()
            goto L_0x0071
        L_0x0070:
            r5 = 0
        L_0x0071:
            double r5 = (double) r5
            com.blueair.core.model.SensorType r8 = r10.getSelectedSensorType()
            com.blueair.viewcore.view.StatusLabelState r3 = r3.from(r4, r5, r8)
        L_0x007a:
            r6 = r3
            androidx.lifecycle.MutableLiveData<com.blueair.devicedetails.viewmodel.DeviceDetailsState> r9 = r10._deviceDetailsState
            r4 = r0
            com.blueair.devicedetails.viewmodel.DeviceDetailsState r0 = new com.blueair.devicedetails.viewmodel.DeviceDetailsState
            com.blueair.core.model.SensorType r3 = r10.getSelectedSensorType()
            com.blueair.devicedetails.viewmodel.DeviceSettingsType r5 = r10.getSelectedSettingsType()
            r8 = 0
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.postValue(r0)
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel.updateState():void");
    }

    public final Job linkDeviceSelected(HasLinkingCapability hasLinkingCapability, DeviceAware deviceAware) {
        Intrinsics.checkNotNullParameter(hasLinkingCapability, "parentDevice");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$linkDeviceSelected$1(hasLinkingCapability, deviceAware, this, (Continuation<? super DeviceDetailsViewModel$linkDeviceSelected$1>) null), 2, (Object) null);
    }

    private final /* synthetic */ <T extends Device> Job setActuator(Device device, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.needClassReification();
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setActuator$1(device, function2, (Continuation<? super DeviceDetailsViewModel$setActuator$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ Job setApSubMode$default(DeviceDetailsViewModel deviceDetailsViewModel, Device device, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return deviceDetailsViewModel.setApSubMode(device, i, z);
    }

    public static /* synthetic */ Job setAlarm$default(DeviceDetailsViewModel deviceDetailsViewModel, Device device, int i, DeviceAlarm deviceAlarm, Function2 function2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function2 = null;
        }
        return deviceDetailsViewModel.setAlarm(device, i, deviceAlarm, function2);
    }

    public final void autoRefreshEnabledChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device instanceof HasAirRefresh) {
            if (((HasAirRefresh) device).getAirRefreshEnabled()) {
                String format = String.format(PrefKeys.KEY_AUTO_REFRESH_HINT_CLOSED_BEFORE, Arrays.copyOf(new Object[]{device.getUid()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                PreferencesHelper.INSTANCE.set(getPrefs().getBackend(), format, false, Reflection.getOrCreateKotlinClass(Boolean.class));
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$autoRefreshEnabledChanged$1(this, device, (Continuation<? super DeviceDetailsViewModel$autoRefreshEnabledChanged$1>) null), 2, (Object) null);
        }
    }

    public final void autoModeFilterTriggerChanged(FilterTrigger filterTrigger) {
        Intrinsics.checkNotNullParameter(filterTrigger, "nuFilterTrigger");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$autoModeFilterTriggerChanged$1(this, filterTrigger, (Continuation<? super DeviceDetailsViewModel$autoModeFilterTriggerChanged$1>) null), 2, (Object) null);
    }

    public final void autoModeFilterTriggerChanged(FilterTrigger filterTrigger, FilterTrigger filterTrigger2) {
        Intrinsics.checkNotNullParameter(filterTrigger, "nuAutoModeFilterTrigger");
        Intrinsics.checkNotNullParameter(filterTrigger2, "nuG4NightModeFilterTrigger");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$autoModeFilterTriggerChanged$2(this, filterTrigger, filterTrigger2, (Continuation<? super DeviceDetailsViewModel$autoModeFilterTriggerChanged$2>) null), 2, (Object) null);
    }

    public final Object setFilter(Device device, Filter filter, Continuation<? super Unit> continuation) {
        Timber.Forest forest = Timber.Forest;
        forest.d("setFilter: nuFilter = " + filter, new Object[0]);
        Object filter2 = getDeviceManager().setFilter(device, filter, continuation);
        return filter2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? filter2 : Unit.INSTANCE;
    }

    public final boolean deviceSupportAntiFake(Device device) {
        return getLocationService().deviceSupportAntiFake(device);
    }

    public final LiveData<FilterLifeResetResult> getResetFilterLifeResult() {
        return this.resetFilterLifeResult;
    }

    public final void resetFilterLife(Device device, DeviceFilterType deviceFilterType) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceFilterType, "type");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$resetFilterLife$1(this, device, deviceFilterType, (Continuation<? super DeviceDetailsViewModel$resetFilterLife$1>) null), 2, (Object) null);
    }

    public static /* synthetic */ void analyticsLogFilterClickEvent$default(DeviceDetailsViewModel deviceDetailsViewModel, Device device, boolean z, boolean z2, DeviceFilterType deviceFilterType, String str, boolean z3, int i, Object obj) {
        if ((i & 32) != 0) {
            z3 = false;
        }
        deviceDetailsViewModel.analyticsLogFilterClickEvent(device, z, z2, deviceFilterType, str, z3);
    }

    public final void analyticsLogFilterClickEvent(Device device, boolean z, boolean z2, DeviceFilterType deviceFilterType, String str, boolean z3) {
        AnalyticEvent.FilterClickEvent filterClickEvent;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(deviceFilterType, "filterType");
        Intrinsics.checkNotNullParameter(str, "filterName");
        if (!z2) {
            this.lastFilterPurchaseClickTime = System.currentTimeMillis();
        }
        if (z) {
            if (z3) {
                DeviceFilterType deviceFilterType2 = deviceFilterType;
                String str2 = str;
                filterClickEvent = new AnalyticEvent.FilterClickEvent.HomepageFilterClickPurchase(this.lastFilterPurchaseClickTime, deviceFilterType2, str2, device, getAuthService().getUserIdForBlueCloud(), getAuthService().getCloudUserRegion());
            } else {
                DeviceFilterType deviceFilterType3 = deviceFilterType;
                String str3 = str;
                filterClickEvent = new AnalyticEvent.FilterClickEvent.FilterCLickPurchase(this.lastFilterPurchaseClickTime, deviceFilterType3, str3, device, getAuthService().getUserIdForBlueCloud(), getAuthService().getCloudUserRegion());
            }
        } else if (z3) {
            DeviceFilterType deviceFilterType4 = deviceFilterType;
            String str4 = str;
            filterClickEvent = new AnalyticEvent.FilterClickEvent.HomepageFilterClickSubscribe(this.lastFilterPurchaseClickTime, deviceFilterType4, str4, device, getAuthService().getUserIdForBlueCloud(), getAuthService().getCloudUserRegion());
        } else {
            DeviceFilterType deviceFilterType5 = deviceFilterType;
            String str5 = str;
            filterClickEvent = new AnalyticEvent.FilterClickEvent.FilterCLickSubscribe(this.lastFilterPurchaseClickTime, deviceFilterType5, str5, device, getAuthService().getUserIdForBlueCloud(), getAuthService().getCloudUserRegion());
        }
        getAnalyticsService().event(filterClickEvent);
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$analyticsLogFilterClickEvent$1(this, filterClickEvent, (Continuation<? super DeviceDetailsViewModel$analyticsLogFilterClickEvent$1>) null), 2, (Object) null);
    }

    public final void openFilterUrl(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        DeviceConfigProvider.INSTANCE.openFilterUrl(context, str, str2);
    }

    public final boolean isInWelcomeHomeRegion() {
        return getLocationService().isInWelcomeHomeRegion() && PhoneUtil.INSTANCE.isGoogleServicesAvailable(getApplication());
    }

    public final String getWarrantyLink() {
        return LinkUtils.INSTANCE.getWarrantyLink(getAuthService().getGigyaJwt(), getLocationService().getDeviceRegion());
    }

    public final void setDeviceName(Device device, String str) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(str, "nuName");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setDeviceName$1(this, device, str, (Continuation<? super DeviceDetailsViewModel$setDeviceName$1>) null), 2, (Object) null);
    }

    public final void removeDevice(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        getDeviceManager().removeDevice(device);
    }

    public final Object removeDeviceWithLock(Device device, Continuation<? super Unit> continuation) {
        Object removeDeviceWithLock = getDeviceManager().removeDeviceWithLock(device, continuation);
        return removeDeviceWithLock == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? removeDeviceWithLock : Unit.INSTANCE;
    }

    public final void ensureUseProtectRegion() {
        DeviceType.Companion.setInG4ProtectRegion(getLocationService().isInG4ProtectRegion());
    }

    public final Job fanspeedSliderChanged(Device device, FanSpeedEnum fanSpeedEnum) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "nuFanSpeedEnum");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$fanspeedSliderChanged$$inlined$setActuator$1(device, (Continuation) null, this, fanSpeedEnum), 2, (Object) null);
    }

    public final Job autoModeChanged(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$autoModeChanged$$inlined$setActuator$1(device, (Continuation) null, device, z, this), 2, (Object) null);
    }

    public final Job setManualMode(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setManualMode$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job standByChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$standByChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job ecoModeChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$ecoModeChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job g4NightModeChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$g4NightModeChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job brightnessChanged(Device device, Brightness brightness) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(brightness, "brightness");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$1(device, (Continuation) null, this, brightness), 2, (Object) null);
    }

    public final Job brightnessChanged(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$brightnessChanged$$inlined$setActuator$2(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job wickDryCanceled(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$wickDryCanceled$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job wickDryEnabledChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$wickDryEnabledChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job autorhChanged(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$autorhChanged$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job timerStatusChanged(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$timerStatusChanged$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job timerDurationChanged(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$timerDurationChanged$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job updateTimerDurationAndRestart(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$updateTimerDurationAndRestart$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job childLockChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$childLockChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job germShieldChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$germShieldChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job disinfectionChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$disinfectionChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job gsnmChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$gsnmChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job oscillationStateChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$oscillationStateChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setOscillationParams(Device device, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setOscillationParams$$inlined$setActuator$1(device, (Continuation) null, this, i, i2, i3), 2, (Object) null);
    }

    public final Job temperatureUnitChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$temperatureUnitChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setMainMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setMainMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setApSubMode(Device device, int i, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setApSubMode$$inlined$setActuator$1(device, (Continuation) null, this, i, z), 2, (Object) null);
    }

    public final Job setApFanSpeed(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setApFanSpeed$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setHeatSubMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setHeatSubMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setHeatFanSpeed(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setHeatFanSpeed$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setHeatAutoTmp(Device device, double d) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setHeatAutoTmp$$inlined$setActuator$1(device, (Continuation) null, this, d), 2, (Object) null);
    }

    public final Job setHeatEcoTmp(Device device, double d) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setHeatEcoTmp$$inlined$setActuator$1(device, (Continuation) null, this, d), 2, (Object) null);
    }

    public final Job setCoolSubMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setCoolSubMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setCoolFanSpeed(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setCoolFanSpeed$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setCoolAutoPresets(Device device, int i, double[] dArr) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setCoolAutoPresets$$inlined$setActuator$1(device, (Continuation) null, this, i, dArr), 2, (Object) null);
    }

    public final Job setCoolEcoPresets(Device device, int i, double[] dArr) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setCoolEcoPresets$$inlined$setActuator$1(device, (Continuation) null, this, i, dArr), 2, (Object) null);
    }

    public final Job hinsModeChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$hinsModeChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job hinsNightModeChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$hinsNightModeChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setMode$$inlined$setActuator$1(device, (Continuation) null, device, i, this), 2, (Object) null);
    }

    public final Job humModeChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$humModeChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setDehSubMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setDehSubMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setSmartSubMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setSmartSubMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setTare(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setTare$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setPanelDisplayMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setPanelDisplayMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job hoverEnabledChanged(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$hoverEnabledChanged$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setAutoRefreshStatus(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setAutoRefreshStatus$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setNightLampBrightness(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setNightLampBrightness$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setNightLampSteplessBrightness(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setNightLampSteplessBrightness$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setWickDryDuration(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setWickDryDuration$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job updateWickDryDurationAndRestart(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$updateWickDryDurationAndRestart$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setYwrmEnabled(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setYwrmEnabled$$inlined$setActuator$1(device, (Continuation) null, this, z), 2, (Object) null);
    }

    public final Job setAlarm(Device device, int i, DeviceAlarm deviceAlarm, Function2<? super ApiResult<SimpleResponse>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setAlarm$$inlined$setActuator$1(device, (Continuation) null, this, i, deviceAlarm, function2), 2, (Object) null);
    }

    public final Job playAlarm(Device device, int i, int i2) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$playAlarm$$inlined$setActuator$1(device, (Continuation) null, this, i, i2), 2, (Object) null);
    }

    public final Job stopAlarm(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$stopAlarm$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }

    public final Job setHumSubMode(Device device, int i) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setHumSubMode$$inlined$setActuator$1(device, (Continuation) null, this, i), 2, (Object) null);
    }

    public final Job setUse24Hour(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$setUse24Hour$$inlined$setActuator$1(device, (Continuation) null, this, z), 2, (Object) null);
    }

    public final Job sensorModeChange(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return BuildersKt__Builders_commonKt.launch$default(this, Dispatchers.getIO(), (CoroutineStart) null, new DeviceDetailsViewModel$sensorModeChange$$inlined$setActuator$1(device, (Continuation) null, this), 2, (Object) null);
    }
}
