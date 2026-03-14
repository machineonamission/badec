package com.blueair.devicedetails.viewmodel;

import android.app.Application;
import android.content.Context;
import android.text.format.DateFormat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Brightness;
import com.blueair.core.model.BrightnessKt;
import com.blueair.core.model.DayOfWeek;
import com.blueair.core.model.DehSubMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceBlue40;
import com.blueair.core.model.DeviceCombo2in120;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceDehumidifier;
import com.blueair.core.model.DeviceHumidifier20;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.DeviceMiniRestful;
import com.blueair.core.model.DeviceNewClassic;
import com.blueair.core.model.DevicePet20;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.DeviceScheduleInstruction;
import com.blueair.core.model.DeviceScheduleMerged;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasAutoRh;
import com.blueair.core.model.HasBlueCloudFunctions;
import com.blueair.core.model.HasBrightness;
import com.blueair.core.model.HasCombo3in1MainMode;
import com.blueair.core.model.HasDehumidifierMainMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasHumMainMode;
import com.blueair.core.model.HasHumMode;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.HasMainMode;
import com.blueair.core.model.HasMode;
import com.blueair.core.model.HasOscillation;
import com.blueair.core.model.HasPetMainMode;
import com.blueair.core.model.HumSubMode;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.Mode;
import com.blueair.core.model.SmartSubMode;
import com.blueair.core.service.UnsecurePrefs;
import com.blueair.devicedetails.util.DeviceScheduleUtils;
import com.blueair.devicemanager.DeviceManager;
import com.blueair.devicemanager.DeviceScheduleService;
import com.blueair.viewcore.R;
import com.blueair.viewcore.extensions.DayOfWeekExtensionKt;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.viewmodel.BaseViewModel;
import io.flatcircle.preferenceshelper2.PreferencesHelper;
import io.flatcircle.preferenceshelper2.Prefs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
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
   d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0004÷\u0001ø\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010Ô\u0001\u001a\u00030Õ\u00012\u0007\u0010Ö\u0001\u001a\u00020,H\u0002JI\u0010×\u0001\u001a\u00030Õ\u00012?\u0010×\u0001\u001a:\u0012\u0016\u0012\u00140@¢\u0006\u000f\bÙ\u0001\u0012\n\bÚ\u0001\u0012\u0005\b\b(Û\u0001\u0012\u0016\u0012\u00140@¢\u0006\u000f\bÙ\u0001\u0012\n\bÚ\u0001\u0012\u0005\b\b(Ü\u0001\u0012\u0005\u0012\u00030Õ\u00010Ø\u0001J\u0019\u0010Û\u0001\u001a\u00020@2\u000e\u0010Ý\u0001\u001a\t\u0012\u0004\u0012\u00020,0Þ\u0001H\u0002J\t\u0010ß\u0001\u001a\u00020@H\u0002J~\u0010à\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010^\u001a\u00020\u001e2\u0007\u0010â\u0001\u001a\u00020\"2\u0007\u0010ã\u0001\u001a\u00020k2\u0007\u0010ä\u0001\u001a\u00020q2\u0007\u0010å\u0001\u001a\u00020v2\u0007\u0010æ\u0001\u001a\u00020~2\b\u0010ç\u0001\u001a\u00030\u0094\u00012\b\u0010è\u0001\u001a\u00030\u0085\u00012\b\u0010é\u0001\u001a\u00030\u0085\u00012\u0007\u0010ê\u0001\u001a\u00020@2\u0007\u0010ë\u0001\u001a\u00020@H\u0002J\u0019\u0010ì\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0019\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001b\u0010î\u0001\u001a\f\u0012\u0005\u0012\u00030á\u0001\u0018\u00010Þ\u00012\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\f\u0010ï\u0001\u001a\u0005\u0018\u00010ð\u0001H\u0002J1\u0010ñ\u0001\u001a\u00030Õ\u00012'\u0010×\u0001\u001a\"\u0012\u0016\u0012\u00140@¢\u0006\u000f\bÙ\u0001\u0012\n\bÚ\u0001\u0012\u0005\b\b(Ü\u0001\u0012\u0005\u0012\u00030Õ\u00010ò\u0001J\t\u0010Ð\u0001\u001a\u00020@H\u0002J\u0011\u0010ó\u0001\u001a\n\u0012\u0005\u0012\u00030á\u00010Þ\u0001H\u0002J\u0012\u0010ô\u0001\u001a\u00030Õ\u00012\b\u0010õ\u0001\u001a\u00030ö\u0001R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010#\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R \u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R(\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0017\u001a\u0004\u0018\u00010,@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b4\u00105R\u000e\u00106\u001a\u000207X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b:\u00105R\u0011\u0010;\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b<\u00105R\u0011\u0010=\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b>\u00105R\u001a\u0010?\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020E@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR$\u0010K\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020E@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR0\u0010P\u001a\b\u0012\u0004\u0012\u00020O0N2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020O0N@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u000203X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00105\"\u0004\bW\u0010XR\u001b\u0010Y\u001a\u0002038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b[\u0010\u000b\u001a\u0004\bZ\u00105R\u0011\u0010\\\u001a\u0002038F¢\u0006\u0006\u001a\u0004\b]\u00105R$\u0010^\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010!\"\u0004\b`\u0010aR\u0017\u0010b\u001a\b\u0012\u0004\u0012\u00020\u001e0'¢\u0006\b\n\u0000\u001a\u0004\bc\u0010)R$\u0010d\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010%\"\u0004\bf\u0010gR\u0017\u0010h\u001a\b\u0012\u0004\u0012\u00020\"0'¢\u0006\b\n\u0000\u001a\u0004\bi\u0010)R\u001a\u0010j\u001a\u00020kX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u001a\u0010p\u001a\u00020qX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010w\u001a\u00020v2\u0006\u0010\u0017\u001a\u00020v@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\u0017\u0010|\u001a\b\u0012\u0004\u0012\u00020v0'¢\u0006\b\n\u0000\u001a\u0004\b}\u0010)R(\u0010\u007f\u001a\u00020~2\u0006\u0010\u0017\u001a\u00020~@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R \u0010\u0084\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R \u0010\u008a\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008b\u0001\u0010\u0087\u0001\"\u0006\b\u008c\u0001\u0010\u0089\u0001R\u001d\u0010\u008d\u0001\u001a\u00020@X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010B\"\u0005\b\u008f\u0001\u0010DR\u001d\u0010\u0090\u0001\u001a\u00020@X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010B\"\u0005\b\u0092\u0001\u0010DR \u0010\u0093\u0001\u001a\u00030\u0094\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001d\u0010\u0099\u0001\u001a\u00020\"X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010%\"\u0005\b\u009b\u0001\u0010gR\u001d\u0010\u009c\u0001\u001a\u00020kX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009d\u0001\u0010m\"\u0005\b\u009e\u0001\u0010oR\u0019\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u0002030'¢\u0006\t\n\u0000\u001a\u0005\b \u0001\u0010)R'\u0010¡\u0001\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00020\u001e@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¢\u0001\u0010!\"\u0005\b£\u0001\u0010aR\u0019\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020\u001e0'¢\u0006\t\n\u0000\u001a\u0005\b¥\u0001\u0010)R'\u0010¦\u0001\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\"@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010%\"\u0005\b¨\u0001\u0010gR\u0019\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\"0'¢\u0006\t\n\u0000\u001a\u0005\bª\u0001\u0010)R\u001d\u0010«\u0001\u001a\u00020kX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¬\u0001\u0010m\"\u0005\b\u00ad\u0001\u0010oR\u001d\u0010®\u0001\u001a\u00020qX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¯\u0001\u0010s\"\u0005\b°\u0001\u0010uR'\u0010±\u0001\u001a\u00020v2\u0006\u0010\u0017\u001a\u00020v@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b²\u0001\u0010y\"\u0005\b³\u0001\u0010{R\u0019\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020v0'¢\u0006\t\n\u0000\u001a\u0005\bµ\u0001\u0010)R)\u0010¶\u0001\u001a\u00020~2\u0006\u0010\u0017\u001a\u00020~@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b·\u0001\u0010\u0081\u0001\"\u0006\b¸\u0001\u0010\u0083\u0001R \u0010¹\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010\u0087\u0001\"\u0006\b»\u0001\u0010\u0089\u0001R \u0010¼\u0001\u001a\u00030\u0085\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b½\u0001\u0010\u0087\u0001\"\u0006\b¾\u0001\u0010\u0089\u0001R\u001d\u0010¿\u0001\u001a\u00020@X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010B\"\u0005\bÁ\u0001\u0010DR\u001d\u0010Â\u0001\u001a\u00020@X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010B\"\u0005\bÄ\u0001\u0010DR \u0010Å\u0001\u001a\u00030\u0094\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010\u0096\u0001\"\u0006\bÇ\u0001\u0010\u0098\u0001R\u0019\u0010È\u0001\u001a\b\u0012\u0004\u0012\u00020@0'¢\u0006\t\n\u0000\u001a\u0005\bÉ\u0001\u0010)R\u0019\u0010Ê\u0001\u001a\b\u0012\u0004\u0012\u00020@0'¢\u0006\t\n\u0000\u001a\u0005\bË\u0001\u0010)R\u001b\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00020@0Í\u0001¢\u0006\n\n\u0000\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0019\u0010Ð\u0001\u001a\b\u0012\u0004\u0012\u00020@0'¢\u0006\t\n\u0000\u001a\u0005\bÐ\u0001\u0010)R'\u0010Ñ\u0001\u001a\u00020@2\u0006\u0010\u0017\u001a\u00020@8F@FX\u0086\u000e¢\u0006\u000e\u001a\u0005\bÒ\u0001\u0010B\"\u0005\bÓ\u0001\u0010D¨\u0006ù\u0001"},
   d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel;", "Lcom/blueair/viewcore/viewmodel/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "deviceScheduleService", "Lcom/blueair/devicemanager/DeviceScheduleService;", "getDeviceScheduleService", "()Lcom/blueair/devicemanager/DeviceScheduleService;", "deviceScheduleService$delegate", "Lkotlin/Lazy;", "prefs", "Lcom/blueair/core/service/UnsecurePrefs;", "getPrefs", "()Lcom/blueair/core/service/UnsecurePrefs;", "prefs$delegate", "state", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "getState", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "setState", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;)V", "value", "Lcom/blueair/core/model/Device;", "device", "getDevice", "()Lcom/blueair/core/model/Device;", "setDevice", "(Lcom/blueair/core/model/Device;)V", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "defaultPurifierMode", "getDefaultPurifierMode", "()Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "Lcom/blueair/core/model/FanSpeedEnum;", "defaultFanSpeed", "getDefaultFanSpeed", "()Lcom/blueair/core/model/FanSpeedEnum;", "liveDevice", "Landroidx/lifecycle/MutableLiveData;", "getLiveDevice", "()Landroidx/lifecycle/MutableLiveData;", "setLiveDevice", "(Landroidx/lifecycle/MutableLiveData;)V", "Lcom/blueair/core/model/DeviceScheduleMerged;", "editingSchedule", "getEditingSchedule", "()Lcom/blueair/core/model/DeviceScheduleMerged;", "setEditingSchedule", "(Lcom/blueair/core/model/DeviceScheduleMerged;)V", "title", "", "getTitle", "()Ljava/lang/String;", "currentTimeFormatter", "Ljava/text/SimpleDateFormat;", "timeFormatter", "displayStartTime", "getDisplayStartTime", "displayEndTime", "getDisplayEndTime", "displayRepeat", "getDisplayRepeat", "paused", "", "getPaused", "()Z", "setPaused", "(Z)V", "Ljava/util/Calendar;", "startTime", "getStartTime", "()Ljava/util/Calendar;", "setStartTime", "(Ljava/util/Calendar;)V", "endTime", "getEndTime", "setEndTime", "", "Lcom/blueair/core/model/DayOfWeek;", "repeat", "getRepeat", "()Ljava/util/Set;", "setRepeat", "(Ljava/util/Set;)V", "label", "getLabel", "setLabel", "(Ljava/lang/String;)V", "defaultLabel", "getDefaultLabel", "defaultLabel$delegate", "displayLabel", "getDisplayLabel", "purifierMode", "getPurifierMode", "setPurifierMode", "(Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;)V", "livePurifierMode", "getLivePurifierMode", "startFanSpeed", "getStartFanSpeed", "setStartFanSpeed", "(Lcom/blueair/core/model/FanSpeedEnum;)V", "liveStartFanSpeed", "getLiveStartFanSpeed", "startBrightness", "", "getStartBrightness", "()Ljava/lang/Object;", "setStartBrightness", "(Ljava/lang/Object;)V", "startAutoRh", "", "getStartAutoRh", "()I", "setStartAutoRh", "(I)V", "Lcom/blueair/core/model/MainMode;", "startMainMode", "getStartMainMode", "()Lcom/blueair/core/model/MainMode;", "setStartMainMode", "(Lcom/blueair/core/model/MainMode;)V", "liveMainMode", "getLiveMainMode", "Lcom/blueair/core/model/ApSubMode;", "startApSubMode", "getStartApSubMode", "()Lcom/blueair/core/model/ApSubMode;", "setStartApSubMode", "(Lcom/blueair/core/model/ApSubMode;)V", "startHeatAutoTemp", "", "getStartHeatAutoTemp", "()D", "setStartHeatAutoTemp", "(D)V", "startHeatEcoTemp", "getStartHeatEcoTemp", "setStartHeatEcoTemp", "startOscillationEnabled", "getStartOscillationEnabled", "setStartOscillationEnabled", "startHumMode", "getStartHumMode", "setStartHumMode", "startSmartSubMode", "Lcom/blueair/core/model/SmartSubMode;", "getStartSmartSubMode", "()Lcom/blueair/core/model/SmartSubMode;", "setStartSmartSubMode", "(Lcom/blueair/core/model/SmartSubMode;)V", "endFanSpeed", "getEndFanSpeed", "setEndFanSpeed", "endBrightness", "getEndBrightness", "setEndBrightness", "scheduleEndType", "getScheduleEndType", "scheduleEndCustomMode", "getScheduleEndCustomMode", "setScheduleEndCustomMode", "liveScheduleEndCustomMode", "getLiveScheduleEndCustomMode", "scheduleEndCustomFanSpeed", "getScheduleEndCustomFanSpeed", "setScheduleEndCustomFanSpeed", "liveScheduleEndCustomFanSpeed", "getLiveScheduleEndCustomFanSpeed", "scheduleEndCustomBrightness", "getScheduleEndCustomBrightness", "setScheduleEndCustomBrightness", "scheduleEndCustomAutoRh", "getScheduleEndCustomAutoRh", "setScheduleEndCustomAutoRh", "scheduleEndCustomMainMode", "getScheduleEndCustomMainMode", "setScheduleEndCustomMainMode", "liveScheduleEndCustomMainMode", "getLiveScheduleEndCustomMainMode", "scheduleEndCustomApSubMode", "getScheduleEndCustomApSubMode", "setScheduleEndCustomApSubMode", "scheduleEndCustomHeatAutoTemp", "getScheduleEndCustomHeatAutoTemp", "setScheduleEndCustomHeatAutoTemp", "scheduleEndCustomHeatEcoTemp", "getScheduleEndCustomHeatEcoTemp", "setScheduleEndCustomHeatEcoTemp", "scheduleEndCustomOscillationEnabled", "getScheduleEndCustomOscillationEnabled", "setScheduleEndCustomOscillationEnabled", "scheduleEndCustomHumMode", "getScheduleEndCustomHumMode", "setScheduleEndCustomHumMode", "scheduleEndCustomSmartSubMode", "getScheduleEndCustomSmartSubMode", "setScheduleEndCustomSmartSubMode", "validState", "getValidState", "requesting", "getRequesting", "saveBtnEnabled", "Landroidx/lifecycle/MediatorLiveData;", "getSaveBtnEnabled", "()Landroidx/lifecycle/MediatorLiveData;", "isStartTimeSameAsEndTime", "scheduleEndTypeHintClosedBefore", "getScheduleEndTypeHintClosedBefore", "setScheduleEndTypeHintClosedBefore", "configureForModify", "", "scheduleMerged", "onComplete", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "hasOverlap", "success", "allSchedules", "", "validateModel", "buildInstructions", "Lcom/blueair/core/model/DeviceScheduleInstruction;", "fanSpeed", "brightness", "autoRh", "mainMode", "apSubMode", "smartSubMode", "heatAutoTemp", "heatEcoTemp", "oscillationEnabled", "humMode", "buildStartInstructions", "buildEndCustomInstructions", "buildLegacyEndInstructions", "toDeviceSchedule", "Lcom/blueair/core/model/DeviceSchedule;", "delete", "Lkotlin/Function1;", "resetAutoAndNightInstructions", "initTimeFormat", "context", "Landroid/content/Context;", "State", "PurifierMode", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceCreateEditScheduleViewModel extends BaseViewModel {
   static final KProperty[] $$delegatedProperties = new KProperty[]{Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceCreateEditScheduleViewModel.class, "deviceScheduleService", "getDeviceScheduleService()Lcom/blueair/devicemanager/DeviceScheduleService;", 0))), Reflection.property1((PropertyReference1)(new PropertyReference1Impl(DeviceCreateEditScheduleViewModel.class, "prefs", "getPrefs()Lcom/blueair/core/service/UnsecurePrefs;", 0)))};
   private SimpleDateFormat currentTimeFormatter;
   private FanSpeedEnum defaultFanSpeed;
   private final Lazy defaultLabel$delegate;
   private PurifierMode defaultPurifierMode;
   private Device device;
   private final Lazy deviceScheduleService$delegate;
   private DeviceScheduleMerged editingSchedule;
   private Object endBrightness;
   private FanSpeedEnum endFanSpeed;
   private Calendar endTime;
   private final MutableLiveData isStartTimeSameAsEndTime;
   private String label;
   private MutableLiveData liveDevice;
   private final MutableLiveData liveMainMode;
   private final MutableLiveData livePurifierMode;
   private final MutableLiveData liveScheduleEndCustomFanSpeed;
   private final MutableLiveData liveScheduleEndCustomMainMode;
   private final MutableLiveData liveScheduleEndCustomMode;
   private final MutableLiveData liveStartFanSpeed;
   private boolean paused;
   private final Lazy prefs$delegate;
   private PurifierMode purifierMode;
   private Set repeat;
   private final MutableLiveData requesting;
   private final MediatorLiveData saveBtnEnabled;
   private ApSubMode scheduleEndCustomApSubMode;
   private int scheduleEndCustomAutoRh;
   private Object scheduleEndCustomBrightness;
   private FanSpeedEnum scheduleEndCustomFanSpeed;
   private double scheduleEndCustomHeatAutoTemp;
   private double scheduleEndCustomHeatEcoTemp;
   private boolean scheduleEndCustomHumMode;
   private MainMode scheduleEndCustomMainMode;
   private PurifierMode scheduleEndCustomMode;
   private boolean scheduleEndCustomOscillationEnabled;
   private SmartSubMode scheduleEndCustomSmartSubMode;
   private final MutableLiveData scheduleEndType;
   private ApSubMode startApSubMode;
   private int startAutoRh;
   private Object startBrightness;
   private FanSpeedEnum startFanSpeed;
   private double startHeatAutoTemp;
   private double startHeatEcoTemp;
   private boolean startHumMode;
   private MainMode startMainMode;
   private boolean startOscillationEnabled;
   private SmartSubMode startSmartSubMode;
   private Calendar startTime;
   private State state;
   private final SimpleDateFormat timeFormatter;
   private final MutableLiveData validState;

   // $FF: synthetic method
   public static Unit $r8$lambda$7geBlYLDx67NGKTzgu65q2_7EfE/* $FF was: $r8$lambda$7geBlYLDx67NGKTzgu65q2-7EfE*/(MediatorLiveData var0, DeviceCreateEditScheduleViewModel var1, Boolean var2) {
      return saveBtnEnabled$lambda$8$lambda$6(var0, var1, var2);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$BXZOIoiqqoCQT1VvSjGX98FL59w(DeviceCreateEditScheduleViewModel var0, PurifierMode var1, MainMode var2, ApSubMode var3, SmartSubMode var4, FanSpeedEnum var5, Object var6, int var7, double var8, double var10, boolean var12, boolean var13) {
      return configureForModify$lambda$42(var0, var1, var2, var3, var4, var5, var6, var7, var8, var10, var12, var13);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$MKZDYAUC0hwtwrHlvNFT6nXnNTY(DeviceCreateEditScheduleViewModel var0, PurifierMode var1, MainMode var2, ApSubMode var3, SmartSubMode var4, FanSpeedEnum var5, Object var6, int var7, double var8, double var10, boolean var12, boolean var13) {
      return configureForModify$lambda$41(var0, var1, var2, var3, var4, var5, var6, var7, var8, var10, var12, var13);
   }

   // $FF: synthetic method
   public static CharSequence $r8$lambda$OJaDapAtFnBaNQAJuY7NfmAcKUU(Application var0, DayOfWeek var1) {
      return _get_displayRepeat_$lambda$1(var0, var1);
   }

   // $FF: synthetic method
   public static String $r8$lambda$PS9a8TQ5VW0vuQ7c0z3Q61B08Tw(DeviceCreateEditScheduleViewModel var0) {
      return defaultLabel_delegate$lambda$4(var0);
   }

   // $FF: synthetic method
   public static Unit $r8$lambda$WZfid4P0sfiy7KaYvwIjxQ31bKQ(MediatorLiveData var0, DeviceCreateEditScheduleViewModel var1, Boolean var2) {
      return saveBtnEnabled$lambda$8$lambda$7(var0, var1, var2);
   }

   public DeviceCreateEditScheduleViewModel(Application var1) {
      Intrinsics.checkNotNullParameter(var1, "application");
      super(var1);
      DIAware var2 = this;
      JVMTypeToken var5 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var5, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      LazyDelegate var4 = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var5, DeviceScheduleService.class)), (Object)null);
      KProperty[] var3 = $$delegatedProperties;
      Boolean var6 = false;
      this.deviceScheduleService$delegate = var4.provideDelegate(this, var3[0]);
      JVMTypeToken var12 = TypeTokensJVMKt.typeToken((new TypeReference() {
      }).getSuperType());
      Intrinsics.checkNotNull(var12, "null cannot be cast to non-null type org.kodein.type.JVMTypeToken<T of org.kodein.type.TypeTokensJVMKt.generic>");
      this.prefs$delegate = DIAwareKt.Instance(var2, (TypeToken)(new GenericJVMTypeTokenDelegate(var12, UnsecurePrefs.class)), (Object)null).provideDelegate(this, var3[1]);
      this.state = DeviceCreateEditScheduleViewModel.State.NEW;
      this.defaultPurifierMode = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
      this.defaultFanSpeed = FanSpeedEnum.OFF;
      this.liveDevice = new MutableLiveData();
      this.timeFormatter = new SimpleDateFormat("HH:mm");
      Calendar var7 = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(var7, "getInstance(...)");
      this.startTime = var7;
      DeviceCreateEditScheduleViewModel var8 = this;
      Calendar var9 = Calendar.getInstance();
      var9.add(10, 1);
      Intrinsics.checkNotNullExpressionValue(var9, "run(...)");
      this.endTime = var9;
      this.repeat = SetsKt.setOf(new DayOfWeek[]{DayOfWeek.SUN, DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI, DayOfWeek.SAT});
      this.label = "";
      this.defaultLabel$delegate = LazyKt.lazy(new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda2(this));
      this.purifierMode = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
      this.livePurifierMode = new MutableLiveData(this.purifierMode);
      this.startFanSpeed = FanSpeedEnum.OFF;
      this.liveStartFanSpeed = new MutableLiveData(this.startFanSpeed);
      this.startBrightness = Brightness.TWO;
      this.startAutoRh = 50;
      this.startMainMode = MainMode.AirPurify;
      this.liveMainMode = new MutableLiveData(this.startMainMode);
      this.startApSubMode = ApSubMode.AUTO;
      this.startHeatAutoTemp = (double)22.0F;
      this.startHeatEcoTemp = (double)22.0F;
      this.startHumMode = true;
      this.startSmartSubMode = SmartSubMode.AUTO_ON;
      this.endFanSpeed = FanSpeedEnum.ONE;
      this.endBrightness = Brightness.ONE;
      this.scheduleEndType = new MutableLiveData("previous");
      this.scheduleEndCustomMode = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
      this.liveScheduleEndCustomMode = new MutableLiveData(this.scheduleEndCustomMode);
      this.scheduleEndCustomFanSpeed = FanSpeedEnum.OFF;
      this.liveScheduleEndCustomFanSpeed = new MutableLiveData(this.scheduleEndCustomFanSpeed);
      this.scheduleEndCustomBrightness = Brightness.TWO;
      this.scheduleEndCustomAutoRh = 50;
      this.scheduleEndCustomMainMode = MainMode.AirPurify;
      this.liveScheduleEndCustomMainMode = new MutableLiveData(this.scheduleEndCustomMainMode);
      this.scheduleEndCustomApSubMode = ApSubMode.AUTO;
      this.scheduleEndCustomHeatAutoTemp = (double)22.0F;
      this.scheduleEndCustomHeatEcoTemp = (double)22.0F;
      this.scheduleEndCustomHumMode = true;
      this.scheduleEndCustomSmartSubMode = SmartSubMode.AUTO_ON;
      MutableLiveData var13 = new MutableLiveData(var6);
      this.validState = var13;
      MutableLiveData var10 = new MutableLiveData(var6);
      this.requesting = var10;
      MediatorLiveData var11 = new MediatorLiveData();
      var11.addSource((LiveData)var13, new Observer(new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda3(var11, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      var11.addSource((LiveData)var10, new Observer(new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda4(var11, this)) {
         private final Function1 function;

         {
            Intrinsics.checkNotNullParameter(var1, "function");
            this.function = var1;
         }

         public final boolean equals(Object var1) {
            return var1 instanceof Observer && var1 instanceof FunctionAdapter ? Intrinsics.areEqual(((FunctionAdapter)this).getFunctionDelegate(), ((FunctionAdapter)var1).getFunctionDelegate()) : false;
         }

         public final Function getFunctionDelegate() {
            return (Function)this.function;
         }

         public final int hashCode() {
            return ((FunctionAdapter)this).getFunctionDelegate().hashCode();
         }

         // $FF: synthetic method
         public final void onChanged(Object var1) {
            this.function.invoke(var1);
         }
      });
      this.saveBtnEnabled = var11;
      this.isStartTimeSameAsEndTime = new MutableLiveData(var6);
      this.validateModel();
   }

   private static final CharSequence _get_displayRepeat_$lambda$1(Application var0, DayOfWeek var1) {
      Intrinsics.checkNotNullParameter(var1, "it");
      Context var2 = var0.getApplicationContext();
      Intrinsics.checkNotNullExpressionValue(var2, "getApplicationContext(...)");
      return (CharSequence)DayOfWeekExtensionKt.displayValueShort(var1, var2);
   }

   private final List buildEndCustomInstructions(Device var1) {
      return this.buildInstructions(var1, this.scheduleEndCustomMode, this.scheduleEndCustomFanSpeed, this.scheduleEndCustomBrightness, this.scheduleEndCustomAutoRh, this.scheduleEndCustomMainMode, this.scheduleEndCustomApSubMode, this.scheduleEndCustomSmartSubMode, this.scheduleEndCustomHeatAutoTemp, this.scheduleEndCustomHeatEcoTemp, this.scheduleEndCustomOscillationEnabled, this.scheduleEndCustomHumMode);
   }

   private final List buildInstructions(Device var1, PurifierMode var2, FanSpeedEnum var3, Object var4, int var5, MainMode var6, ApSubMode var7, SmartSubMode var8, double var9, double var11, boolean var13, boolean var14) {
      List var30 = (List)(new ArrayList());
      if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
         buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getDefaultValue());
         return var30;
      } else {
         if (var1 instanceof HasDehumidifierMainMode) {
            buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(var6.getValue()));
            int var15 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
            if (var15 == 1) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
               DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var17 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
               Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
               buildInstructions$addInstruction(var30, var17, String.valueOf(var3.toServerValue((HasFanSpeed)var1)));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }

            if (var15 == 2) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
               return var30;
            }

            if (var15 == 3) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE, String.valueOf(DehSubMode.DRYING.getValue()));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }

            if (var15 == 4) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE, String.valueOf(DehSubMode.AUTO.getValue()));
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(var5));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }

            if (var15 == 5) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE, String.valueOf(DehSubMode.CONTINUOUS.getValue()));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }
         } else if (var1 instanceof HasPetMainMode) {
            var5 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
            if (var5 == 1) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.AirPurify.getValue()));
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
               DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var18 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
               Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
               buildInstructions$addInstruction(var30, var18, String.valueOf(var3.toServerValue((HasFanSpeed)var1)));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }

            if (var5 == 2) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.AirPurify.getValue()));
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
               return var30;
            }

            if (var5 == 6) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.SMART.getValue()));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }
         } else if (var1 instanceof HasCombo3in1MainMode) {
            var5 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
            ApSubMode var19;
            if (var5 != 1) {
               if (var5 != 2) {
                  if (var5 != 7) {
                     var19 = ApSubMode.AUTO;
                  } else {
                     var19 = ApSubMode.ECO;
                  }
               } else {
                  var19 = ApSubMode.NIGHT;
               }
            } else {
               var19 = ApSubMode.FAN;
            }

            buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(var6.getValue()));
            if (var1 instanceof HasOscillation && var19 != ApSubMode.ECO && (var3 != FanSpeedEnum.OFF || var19 != ApSubMode.FAN)) {
               DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var16 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.OSCILLATION_STATE;
               String var29;
               if (var13) {
                  var29 = "1";
               } else {
                  var29 = "0";
               }

               buildInstructions$addInstruction(var30, var16, var29);
            }

            if (var1 instanceof HasBrightness && SetsKt.setOf(new ApSubMode[]{ApSubMode.AUTO, ApSubMode.FAN}).contains(var19)) {
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
            }

            var5 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$4[var6.ordinal()];
            if (var5 != 2) {
               if (var5 != 4) {
                  if (var5 == 5) {
                     buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_SUB_MODE, String.valueOf(var19.getValue()));
                     if (var1 instanceof HasFanSpeed && var19 == ApSubMode.FAN) {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_FAN_SPEED, String.valueOf(var3.toServerValue(var1)));
                        return var30;
                     }
                  }
               } else {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_SUB_MODE, String.valueOf(var19.getValue()));
                  var5 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3[var19.ordinal()];
                  if (var5 != 1) {
                     if (var5 == 3) {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_AUTO_TMP, String.valueOf(DeviceData.Companion.toServerValue(var9)));
                        return var30;
                     }

                     if (var5 == 4) {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_ECO_TMP, String.valueOf(DeviceData.Companion.toServerValue(var11)));
                        return var30;
                     }
                  } else if (var1 instanceof HasFanSpeed) {
                     buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_FAN_SPEED, String.valueOf(var3.toServerValue(var1)));
                     return var30;
                  }
               }
            } else {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(var19.getValue()));
               if (var1 instanceof HasFanSpeed && var19 == ApSubMode.FAN) {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_FAN_SPEED, String.valueOf(var3.toServerValue(var1)));
                  return var30;
               }
            }
         } else if (var1 instanceof HasHumMainMode) {
            buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(var6.getValue()));
            if (var6 == MainMode.Humidification) {
               int var32 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
               if (var32 != 1) {
                  if (var32 != 2) {
                     if (var32 != 4) {
                        if (var32 == 8) {
                           buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.SKIN.getValue()));
                        }
                     } else {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.AUTO.getValue()));
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(var5));
                     }
                  } else {
                     buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.NIGHT.getValue()));
                  }
               } else {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE, String.valueOf(HumSubMode.FAN.getValue()));
                  DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var27 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                  Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                  buildInstructions$addInstruction(var30, var27, String.valueOf(var3.toServerValue((HasFanSpeed)var1)));
               }
            } else {
               var5 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
               if (var5 != 1) {
                  if (var5 != 2) {
                     if (var5 == 4) {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.AUTO.getValue()));
                     }
                  } else {
                     buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
                  }
               } else {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
                  DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var28 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
                  Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
                  buildInstructions$addInstruction(var30, var28, String.valueOf(var3.toServerValue((HasFanSpeed)var1)));
               }
            }

            if (var2 != DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT) {
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }
         } else if (var1 instanceof HasMainMode) {
            buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE, String.valueOf(MainMode.AirPurify.getValue()));
            var5 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
            if (var5 == 1) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.FAN.getValue()));
               DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var20 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED;
               Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type com.blueair.core.model.HasFanSpeed");
               buildInstructions$addInstruction(var30, var20, String.valueOf(var3.toServerValue((HasFanSpeed)var1)));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }

            if (var5 == 2) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.NIGHT.getValue()));
               return var30;
            }

            if (var5 == 4) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.AUTO.getValue()));
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }

            if (var5 == 7) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE, String.valueOf(ApSubMode.ECO.getValue()));
               return var30;
            }
         } else if (var1 instanceof HasMode) {
            var13 = var1 instanceof HasHumMode;
            if (var13) {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_MODE, String.valueOf(var14));
            }

            int var33 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
            if (var33 != 1) {
               if (var33 != 2) {
                  if (var33 == 4) {
                     buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE, String.valueOf(Mode.AUTO.getValue()));
                     if (var1 instanceof HasAutoRh && (!var13 || var14)) {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(var5));
                     }
                  }
               } else {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE, String.valueOf(Mode.NIGHT.getValue()));
               }
            } else {
               buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE, String.valueOf(Mode.FAN.getValue()));
               if (var1 instanceof HasFanSpeed) {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED, String.valueOf(var3.toServerValue(var1)));
               }
            }

            if (var1 instanceof HasBrightness && var2 != DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT) {
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
               return var30;
            }
         } else if (var1 instanceof HasBlueCloudFunctions) {
            if (var1 instanceof HasFanSpeed) {
               int var34 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$5[var2.ordinal()];
               if (var34 != 1) {
                  if (var34 != 2) {
                     if (var34 != 4) {
                        if (var34 != 7) {
                           if (var34 == 9) {
                              buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getDefaultValue());
                           }
                        } else {
                           buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getDefaultValue());
                        }
                     } else {
                        buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getDefaultValue());
                        if (var1 instanceof HasAutoRh) {
                           buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH, String.valueOf(var5));
                        }
                     }
                  } else {
                     buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getDefaultValue());
                  }
               } else {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED, String.valueOf(var3.toServerValue(var1)));
               }
            }

            if (var1 instanceof HasBrightness && !SetsKt.setOf(new PurifierMode[]{DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT, DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY, DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION}).contains(var2) && (var2 != DeviceCreateEditScheduleViewModel.PurifierMode.ECO || !(var1 instanceof DeviceNewClassic))) {
               buildInstructions$addBrightnessInstruction(var4, var1, var30, false);
            }

            if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL) {
               var30.addAll((Collection)this.resetAutoAndNightInstructions());
               return var30;
            }
         } else {
            if (var1 instanceof HasFanSpeed) {
               if (var2 == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO) {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getDefaultValue());
               } else {
                  buildInstructions$addInstruction(var30, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED, String.valueOf(var3.toServerValue(var1)));
               }
            }

            if (var1 instanceof HasBrightness) {
               buildInstructions$addBrightnessInstruction(var4, var1, var30, true);
            }
         }

         return var30;
      }
   }

   private static final void buildInstructions$addBrightnessInstruction(Object var0, Device var1, List var2, boolean var3) {
      Object var6;
      if (var0 instanceof Brightness) {
         var6 = ((Brightness)var0).toServerValue(var1);
      } else {
         var6 = var0;
         if (var0 instanceof Integer) {
            int var5 = ((Number)var0).intValue();
            byte var4;
            if (DeviceKt.useNewBrightnessRange(var1)) {
               var4 = 10;
            } else {
               var4 = 0;
            }

            var6 = RangesKt.coerceIn(var5, var4, 100);
         }
      }

      DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var7;
      if (var3) {
         var7 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS;
      } else {
         var7 = DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.BRIGHTNESS;
      }

      buildInstructions$addInstruction(var2, var7, var6.toString());
   }

   private static final void buildInstructions$addInstruction(List var0, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType var1, String var2) {
      var0.add(DeviceScheduleInstruction.Companion.newInstance(var1, var2));
   }

   private final List buildLegacyEndInstructions(Device var1) {
      List var4 = (List)(new ArrayList());
      if (var1 instanceof HasBrightness) {
         Object var3 = this.endBrightness;
         Object var2 = var3;
         if (var3 instanceof Brightness) {
            Intrinsics.checkNotNull(var3, "null cannot be cast to non-null type com.blueair.core.model.Brightness");
            var2 = ((Brightness)var3).toServerValue(var1);
         }

         var4.add(DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS, String.valueOf(var2)));
      }

      if (var1 instanceof HasFanSpeed) {
         var4.add(DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED, String.valueOf(this.endFanSpeed.toServerValue(var1))));
      }

      return var4.isEmpty() ? null : var4;
   }

   private final List buildStartInstructions(Device var1) {
      return this.buildInstructions(var1, this.purifierMode, this.startFanSpeed, this.startBrightness, this.startAutoRh, this.startMainMode, this.startApSubMode, this.startSmartSubMode, this.startHeatAutoTemp, this.startHeatEcoTemp, this.startOscillationEnabled, this.startHumMode);
   }

   private final void configureForModify(DeviceScheduleMerged var1) {
      this.state = DeviceCreateEditScheduleViewModel.State.MODIFY;
      Calendar var3 = var1.timeToCalendar(var1.getStartTime());
      Calendar var2 = var3;
      if (var3 == null) {
         var2 = Calendar.getInstance();
         Intrinsics.checkNotNullExpressionValue(var2, "getInstance(...)");
      }

      this.setStartTime(var2);
      var3 = var1.timeToCalendar(var1.getEndTime());
      var2 = var3;
      if (var3 == null) {
         var2 = Calendar.getInstance();
         Intrinsics.checkNotNullExpressionValue(var2, "getInstance(...)");
      }

      this.setEndTime(var2);
      this.setRepeat(var1.getDaysOfWeek());
      this.label = var1.getName();
      this.paused = var1.getPaused();
      configureForModify$configureInstructions(this, var1.getInstructions(), new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda0(this));
      MutableLiveData var4 = this.scheduleEndType;
      String var8 = var1.getEndScheduleMode();
      String var6 = var8;
      if (var8 == null) {
         var6 = "previous";
      }

      var4.setValue(var6);
      configureForModify$configureInstructions(this, var1.getEndInstructions(), new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda1(this));
   }

   private static final void configureForModify$configureInstructions(DeviceCreateEditScheduleViewModel var0, List var1, Function11 var2) {
      PurifierMode var20 = var0.defaultPurifierMode;
      MainMode var18 = MainMode.AirPurify;
      ApSubMode var17 = ApSubMode.AUTO;
      SmartSubMode var15 = SmartSubMode.AUTO_ON;
      DehSubMode var19 = DehSubMode.AUTO;
      HumSubMode var16 = HumSubMode.AUTO;
      FanSpeedEnum var12 = var0.defaultFanSpeed;
      Object var14 = Brightness.TWO;
      double var3;
      double var5;
      int var7;
      boolean var9;
      boolean var10;
      HumSubMode var36;
      PurifierMode var65;
      MainMode var75;
      SmartSubMode var79;
      DehSubMode var84;
      if (var0.device instanceof HasBlueCloudFunctions) {
         Iterator var26 = var1.iterator();
         var9 = true;
         var10 = false;
         var7 = 50;
         var5 = (double)22.0F;
         var3 = (double)22.0F;
         HumSubMode var13 = var16;
         DehSubMode var76 = var19;
         PurifierMode var35 = var20;

         while(var26.hasNext()) {
            DeviceScheduleInstruction var85 = (DeviceScheduleInstruction)var26.next();
            String var27 = var85.getName();
            if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getInstructionName())) {
               if (Intrinsics.areEqual(var85.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE.getDefaultValue())) {
                  var35 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
               } else {
                  var35 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
               }

               Unit var134 = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getInstructionName())) {
               if (Intrinsics.areEqual(var85.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE.getDefaultValue())) {
                  var35 = DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
               }

               Unit var133 = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.FAN_SPEED.getInstructionName())) {
               Device var146 = var0.device;
               if (var146 != null) {
                  Integer var130 = StringsKt.toIntOrNull(var85.getValue());
                  if (var130 != null) {
                     int var54 = ((Number)var130).intValue();
                     var12 = FanSpeedEnum.Companion.fromServerValue(var146, var54);
                     Unit var131 = Unit.INSTANCE;
                     var131 = Unit.INSTANCE;
                  }
               }
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.BRIGHTNESS.getInstructionName())) {
               Device var145 = var0.device;
               if (var145 != null) {
                  Integer var127 = StringsKt.toIntOrNull(var85.getValue());
                  if (var127 != null) {
                     int var53 = ((Number)var127).intValue();
                     if (BrightnessKt.hasBrightnessInPercent(var145)) {
                        var14 = var53;
                     } else {
                        var14 = Brightness.Companion.fromServerValue(var145, var53);
                     }

                     Unit var128 = Unit.INSTANCE;
                     var128 = Unit.INSTANCE;
                  }
               }
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_RH.getInstructionName())) {
               Integer var124 = StringsKt.toIntOrNull(var85.getValue());
               if (var124 != null) {
                  var7 = ((Number)var124).intValue();
                  Unit var125 = Unit.INSTANCE;
                  var125 = Unit.INSTANCE;
               }
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getInstructionName())) {
               if (Intrinsics.areEqual(var85.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.STANDBY.getDefaultValue())) {
                  var35 = DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
               }

               Unit var123 = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getInstructionName())) {
               if (Intrinsics.areEqual(var85.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DISINFECTION.getDefaultValue())) {
                  var35 = DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION;
               }

               Unit var122 = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getInstructionName())) {
               if (Intrinsics.areEqual(var85.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.ECO.getDefaultValue())) {
                  var35 = DeviceCreateEditScheduleViewModel.PurifierMode.ECO;
               }

               Unit var121 = Unit.INSTANCE;
            } else {
               boolean var11 = Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MAIN_MODE.getInstructionName());
               Object var23 = null;
               Object var22 = null;
               Object var138 = null;
               Object var25 = null;
               Object var24 = null;
               Object var21 = null;
               if (var11) {
                  Integer var118 = StringsKt.toIntOrNull(var85.getValue());
                  if (var118 != null) {
                     int var52 = ((Number)var118).intValue();
                     Iterator var144 = ((Iterable)MainMode.getEntries()).iterator();

                     do {
                        var119 = var21;
                        if (!var144.hasNext()) {
                           break;
                        }

                        var119 = var144.next();
                     } while(((MainMode)var119).getValue() != var52);

                     MainMode var120 = (MainMode)var119;
                     if (var120 != null) {
                        Unit var82 = Unit.INSTANCE;
                        var82 = Unit.INSTANCE;
                        var18 = var120;
                     }
                  }
               } else if (!Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_SUB_MODE.getInstructionName()) && !Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_SUB_MODE.getInstructionName()) && !Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_SUB_MODE.getInstructionName())) {
                  if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.SMART_SUB_MODE.getInstructionName())) {
                     Integer var115 = StringsKt.toIntOrNull(var85.getValue());
                     if (var115 != null) {
                        int var51 = ((Number)var115).intValue();
                        Iterator var143 = ((Iterable)SmartSubMode.getEntries()).iterator();

                        do {
                           var116 = var23;
                           if (!var143.hasNext()) {
                              break;
                           }

                           var116 = var143.next();
                        } while(((SmartSubMode)var116).getValue() != var51);

                        SmartSubMode var117 = (SmartSubMode)var116;
                        if (var117 != null) {
                           Unit var73 = Unit.INSTANCE;
                           var73 = Unit.INSTANCE;
                           var15 = var117;
                        }
                     }
                  } else if (!Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AP_FAN_SPEED.getInstructionName()) && !Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_FAN_SPEED.getInstructionName()) && !Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.COOL_FAN_SPEED.getInstructionName())) {
                     if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_ECO_TMP.getInstructionName())) {
                        Integer var112 = StringsKt.toIntOrNull(var85.getValue());
                        if (var112 != null) {
                           int var50 = ((Number)var112).intValue();
                           var3 = DeviceData.Companion.fromServerValue(var50);
                           Unit var113 = Unit.INSTANCE;
                           var113 = Unit.INSTANCE;
                        }
                     } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HEAT_AUTO_TMP.getInstructionName())) {
                        Integer var109 = StringsKt.toIntOrNull(var85.getValue());
                        if (var109 != null) {
                           int var49 = ((Number)var109).intValue();
                           var5 = DeviceData.Companion.fromServerValue(var49);
                           Unit var110 = Unit.INSTANCE;
                           var110 = Unit.INSTANCE;
                        }
                     } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.OSCILLATION_STATE.getInstructionName())) {
                        Integer var106 = StringsKt.toIntOrNull(var85.getValue());
                        if (var106 != null) {
                           if (((Number)var106).intValue() == 1) {
                              var10 = true;
                           } else {
                              var10 = false;
                           }

                           Unit var107 = Unit.INSTANCE;
                           var107 = Unit.INSTANCE;
                        }
                     } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.MODE.getInstructionName())) {
                        Integer var101 = StringsKt.toIntOrNull(var85.getValue());
                        if (var101 != null) {
                           int var47 = ((Number)var101).intValue();
                           Iterator var142 = ((Iterable)Mode.getEntries()).iterator();

                           do {
                              var102 = var22;
                              if (!var142.hasNext()) {
                                 break;
                              }

                              var102 = var142.next();
                           } while(((Mode)var102).getValue() != var47);

                           Mode var103 = (Mode)var102;
                           if (var103 != null) {
                              var47 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$1[var103.ordinal()];
                              if (var47 != 1) {
                                 if (var47 != 2) {
                                    if (var47 != 3) {
                                       if (var47 != 4) {
                                          if (var47 != 5) {
                                             throw new NoWhenBranchMatchedException();
                                          }

                                          var35 = DeviceCreateEditScheduleViewModel.PurifierMode.SKIN;
                                       } else {
                                          var35 = DeviceCreateEditScheduleViewModel.PurifierMode.ECO;
                                       }
                                    } else {
                                       var35 = DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
                                    }
                                 } else {
                                    var35 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
                                 }
                              } else {
                                 var35 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
                              }

                              Unit var104 = Unit.INSTANCE;
                              var104 = Unit.INSTANCE;
                           }
                        }
                     } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_MODE.getInstructionName())) {
                        var9 = Boolean.parseBoolean(var85.getValue());
                        Unit var100 = Unit.INSTANCE;
                     } else if (Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.HUM_SUB_MODE.getInstructionName())) {
                        Integer var97 = StringsKt.toIntOrNull(var85.getValue());
                        if (var97 != null) {
                           int var46 = ((Number)var97).intValue();
                           Iterator var153 = ((Iterable)HumSubMode.getEntries()).iterator();

                           do {
                              var98 = var138;
                              if (!var153.hasNext()) {
                                 break;
                              }

                              var98 = var153.next();
                           } while(((HumSubMode)var98).getValue() != var46);

                           HumSubMode var99 = (HumSubMode)var98;
                           if (var99 != null) {
                              Unit var63 = Unit.INSTANCE;
                              var63 = Unit.INSTANCE;
                              var13 = var99;
                           }
                        }
                     } else if (!Intrinsics.areEqual(var27, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.DEH_SUB_MODE.getInstructionName())) {
                        Timber.Forest var141 = Timber.Forest;
                        StringBuilder var152 = new StringBuilder("Schedule Instruction type not supported: ");
                        var152.append(var85);
                        var141.e(var152.toString(), new Object[0]);
                        Unit var96 = Unit.INSTANCE;
                     } else {
                        Integer var93 = StringsKt.toIntOrNull(var85.getValue());
                        if (var93 != null) {
                           int var45 = ((Number)var93).intValue();
                           Iterator var140 = ((Iterable)DehSubMode.getEntries()).iterator();

                           do {
                              var94 = var25;
                              if (!var140.hasNext()) {
                                 break;
                              }

                              var94 = var140.next();
                           } while(((DehSubMode)var94).getValue() != var45);

                           DehSubMode var95 = (DehSubMode)var94;
                           if (var95 != null) {
                              Unit var77 = Unit.INSTANCE;
                              var77 = Unit.INSTANCE;
                              var76 = var95;
                           }
                        }
                     }
                  } else {
                     Integer var89 = StringsKt.toIntOrNull(var85.getValue());
                     if (var89 != null) {
                        int var44 = ((Number)var89).intValue();
                        Device var90 = var0.device;
                        if (var90 != null) {
                           var12 = FanSpeedEnum.Companion.fromServerValue(var90, var44);
                           Unit var91 = Unit.INSTANCE;
                           var91 = Unit.INSTANCE;
                        }
                     }
                  }
               } else {
                  Integer var86 = StringsKt.toIntOrNull(var85.getValue());
                  if (var86 != null) {
                     int var8 = ((Number)var86).intValue();
                     Iterator var139 = ((Iterable)ApSubMode.getEntries()).iterator();

                     do {
                        var87 = var24;
                        if (!var139.hasNext()) {
                           break;
                        }

                        var87 = var139.next();
                     } while(((ApSubMode)var87).getValue() != var8);

                     ApSubMode var88 = (ApSubMode)var87;
                     if (var88 != null) {
                        Unit var80 = Unit.INSTANCE;
                        var80 = Unit.INSTANCE;
                        var17 = var88;
                     }
                  }
               }
            }
         }

         MainMode var135 = var18;
         var84 = var76;
         HumSubMode var147 = var13;
         var79 = var15;
         var65 = var35;
         var36 = var147;
         var75 = var135;
      } else {
         Iterator var155 = var1.iterator();
         Object var37 = var14;
         var65 = var20;

         while(var155.hasNext()) {
            DeviceScheduleInstruction var156 = (DeviceScheduleInstruction)var155.next();
            String var67 = var156.getName();
            PurifierMode var68;
            Object var148;
            FanSpeedEnum var154;
            if (Intrinsics.areEqual(var67, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getInstructionName())) {
               if (Intrinsics.areEqual(var156.getValue(), DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_MODE.getDefaultValue())) {
                  var68 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
               } else {
                  var68 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
               }

               Unit var66 = Unit.INSTANCE;
               var154 = var12;
               var148 = var37;
            } else if (Intrinsics.areEqual(var67, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_FAN_SPEED.getInstructionName())) {
               Device var159 = var0.device;
               var68 = var65;
               var154 = var12;
               var148 = var37;
               if (var159 != null) {
                  Integer var157 = StringsKt.toIntOrNull(var156.getValue());
                  var68 = var65;
                  var154 = var12;
                  var148 = var37;
                  if (var157 != null) {
                     var7 = ((Number)var157).intValue();
                     var154 = FanSpeedEnum.Companion.fromServerValue(var159, var7);
                     var68 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
                     Unit var61 = Unit.INSTANCE;
                     var61 = Unit.INSTANCE;
                     var148 = var37;
                  }
               }
            } else {
               if (!Intrinsics.areEqual(var67, DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.LEGACY_BRIGHTNESS.getInstructionName())) {
                  Timber.Forest var71 = Timber.Forest;
                  StringBuilder var149 = new StringBuilder("Schedule Instruction type not supported: ");
                  var149.append(var156);
                  var71.e(var149.toString(), new Object[0]);
                  Unit var72 = Unit.INSTANCE;
                  continue;
               }

               Device var160 = var0.device;
               var68 = var65;
               var154 = var12;
               var148 = var37;
               if (var160 != null) {
                  Integer var158 = StringsKt.toIntOrNull(var156.getValue());
                  var68 = var65;
                  var154 = var12;
                  var148 = var37;
                  if (var158 != null) {
                     var7 = ((Number)var158).intValue();
                     if (BrightnessKt.hasBrightnessInPercent(var160)) {
                        var37 = var7;
                     } else {
                        var37 = Brightness.Companion.fromServerValue(var160, var7);
                     }

                     Unit var69 = Unit.INSTANCE;
                     var69 = Unit.INSTANCE;
                     var68 = var65;
                     var154 = var12;
                     var148 = var37;
                  }
               }
            }

            var65 = var68;
            var12 = var154;
            var37 = var148;
         }

         var10 = false;
         MainMode var150 = var18;
         var84 = var19;
         HumSubMode var136 = var16;
         var9 = true;
         var7 = 50;
         var5 = (double)22.0F;
         var3 = (double)22.0F;
         var14 = var37;
         var79 = var15;
         var75 = var150;
         var36 = var136;
      }

      Device var151 = var0.device;
      PurifierMode var28;
      FanSpeedEnum var137;
      if (var151 instanceof DeviceDehumidifier) {
         var28 = var65;
         var137 = var12;
         if (var65 != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            int var55 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$4[var75.ordinal()];
            if (var55 != 1) {
               if (var55 != 2) {
                  Unit var29 = Unit.INSTANCE;
                  var28 = var65;
                  var137 = var12;
               } else {
                  var55 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3[var17.ordinal()];
                  if (var55 != 1) {
                     if (var55 != 2) {
                        var28 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
                     } else {
                        var28 = DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
                     }
                  } else {
                     var28 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
                  }

                  Unit var39 = Unit.INSTANCE;
                  var137 = var12;
               }
            } else {
               var55 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$2[var84.ordinal()];
               if (var55 != 1) {
                  if (var55 != 2) {
                     if (var55 != 3) {
                        throw new NoWhenBranchMatchedException();
                     }

                     var28 = DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS;
                  } else {
                     var28 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
                  }
               } else {
                  var28 = DeviceCreateEditScheduleViewModel.PurifierMode.DRYING;
               }

               Unit var40 = Unit.INSTANCE;
               var137 = var12;
            }
         }
      } else if (var151 instanceof HasPetMainMode) {
         PurifierMode var41 = var65;
         if (var65 != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            int var58 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$4[var75.ordinal()];
            if (var58 != 2) {
               if (var58 != 3) {
                  Unit var30 = Unit.INSTANCE;
                  var41 = var65;
               } else {
                  var41 = DeviceCreateEditScheduleViewModel.PurifierMode.SMART;
                  Unit var31 = Unit.INSTANCE;
               }
            } else {
               var58 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3[var17.ordinal()];
               if (var58 != 1) {
                  if (var58 != 2) {
                     Unit var32 = Unit.INSTANCE;
                     var41 = var65;
                  } else {
                     var41 = DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
                     Unit var33 = Unit.INSTANCE;
                  }
               } else {
                  var41 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
                  Unit var34 = Unit.INSTANCE;
               }
            }
         }

         var28 = var41;
         var137 = var12;
         if (var12 == FanSpeedEnum.OFF) {
            var137 = FanSpeedEnum.ELEVEN;
            var28 = var41;
         }
      } else {
         label269: {
            if (var151 instanceof DeviceBlue40) {
               var28 = var65;
               var137 = var12;
               if (var65 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                  break label269;
               }

               int var60 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$3[var17.ordinal()];
               if (var60 != 1) {
                  if (var60 != 2) {
                     if (var60 != 3) {
                        if (var60 != 4) {
                           throw new NoWhenBranchMatchedException();
                        }

                        var28 = DeviceCreateEditScheduleViewModel.PurifierMode.ECO;
                     } else {
                        var28 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
                     }
                  } else {
                     var28 = DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
                  }
               } else {
                  var28 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
               }
            } else {
               var28 = var65;
               var137 = var12;
               if (!(var151 instanceof HasHumMainMode)) {
                  break label269;
               }

               var28 = var65;
               var137 = var12;
               if (var65 == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
                  break label269;
               }

               if (var75 == MainMode.AirPurify) {
                  var28 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromSubMode(var17);
               } else {
                  var28 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromHumSubMode(var36);
               }
            }

            var137 = var12;
         }
      }

      var2.invoke(var28, var75, var17, var79, var137, var14, var7, var5, var3, var10, var9);
   }

   private static final Unit configureForModify$lambda$41(DeviceCreateEditScheduleViewModel var0, PurifierMode var1, MainMode var2, ApSubMode var3, SmartSubMode var4, FanSpeedEnum var5, Object var6, int var7, double var8, double var10, boolean var12, boolean var13) {
      Intrinsics.checkNotNullParameter(var1, "p");
      Intrinsics.checkNotNullParameter(var2, "m");
      Intrinsics.checkNotNullParameter(var3, "aps");
      Intrinsics.checkNotNullParameter(var4, "sms");
      Intrinsics.checkNotNullParameter(var5, "f");
      Intrinsics.checkNotNullParameter(var6, "b");
      var0.setPurifierMode(var1);
      var0.setStartMainMode(var2);
      var0.setStartApSubMode(var3);
      var0.startSmartSubMode = var4;
      var0.setStartFanSpeed(var5);
      var0.startBrightness = var6;
      var0.startAutoRh = var7;
      var0.startHeatAutoTemp = var8;
      var0.startHeatEcoTemp = var10;
      var0.startOscillationEnabled = var12;
      var0.startHumMode = var13;
      return Unit.INSTANCE;
   }

   private static final Unit configureForModify$lambda$42(DeviceCreateEditScheduleViewModel var0, PurifierMode var1, MainMode var2, ApSubMode var3, SmartSubMode var4, FanSpeedEnum var5, Object var6, int var7, double var8, double var10, boolean var12, boolean var13) {
      Intrinsics.checkNotNullParameter(var1, "p");
      Intrinsics.checkNotNullParameter(var2, "m");
      Intrinsics.checkNotNullParameter(var3, "aps");
      Intrinsics.checkNotNullParameter(var4, "sms");
      Intrinsics.checkNotNullParameter(var5, "f");
      Intrinsics.checkNotNullParameter(var6, "b");
      var0.setScheduleEndCustomMode(var1);
      var0.setScheduleEndCustomMainMode(var2);
      var0.setScheduleEndCustomApSubMode(var3);
      var0.scheduleEndCustomSmartSubMode = var4;
      var0.setScheduleEndCustomFanSpeed(var5);
      var0.scheduleEndCustomBrightness = var6;
      var0.scheduleEndCustomAutoRh = var7;
      var0.scheduleEndCustomHeatAutoTemp = var8;
      var0.scheduleEndCustomHeatEcoTemp = var10;
      var0.scheduleEndCustomOscillationEnabled = var12;
      var0.scheduleEndCustomHumMode = var13;
      var0.endFanSpeed = var5;
      var0.endBrightness = var6;
      return Unit.INSTANCE;
   }

   private static final String defaultLabel_delegate$lambda$4(DeviceCreateEditScheduleViewModel var0) {
      String var1 = var0.getApplication().getString(R.string.schedule_default_name);
      Intrinsics.checkNotNullExpressionValue(var1, "getString(...)");
      return var1;
   }

   private final DeviceScheduleService getDeviceScheduleService() {
      return (DeviceScheduleService)this.deviceScheduleService$delegate.getValue();
   }

   private final UnsecurePrefs getPrefs() {
      return (UnsecurePrefs)this.prefs$delegate.getValue();
   }

   private final boolean hasOverlap(List var1) {
      return DeviceScheduleUtils.INSTANCE.testOverlapOfSchedules(this.startTime, this.endTime, this.repeat, this.state, this.editingSchedule, var1);
   }

   private final boolean isStartTimeSameAsEndTime() {
      return DeviceScheduleUtils.INSTANCE.convertCalendarTimeToMinutes(this.startTime) == DeviceScheduleUtils.INSTANCE.convertCalendarTimeToMinutes(this.endTime);
   }

   private static final void onComplete$_onComplete(DeviceCreateEditScheduleViewModel var0, Function2 var1, boolean var2, boolean var3) {
      var0.requesting.postValue(false);
      var1.invoke(var2, var3);
   }

   private final List resetAutoAndNightInstructions() {
      return CollectionsKt.listOf(new DeviceScheduleInstruction[]{DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.AUTO_MODE, "false"), DeviceScheduleInstruction.Companion.newInstance(DeviceScheduleInstruction.Companion.DeviceScheduleInstructionType.NIGHTMODE, "false")});
   }

   private static final Unit saveBtnEnabled$lambda$8$lambda$6(MediatorLiveData var0, DeviceCreateEditScheduleViewModel var1, Boolean var2) {
      boolean var5 = var2;
      boolean var4 = false;
      boolean var3 = var4;
      if (var5) {
         var3 = var4;
         if (Intrinsics.areEqual(var1.requesting.getValue(), false)) {
            var3 = true;
         }
      }

      var0.setValue(var3);
      return Unit.INSTANCE;
   }

   private static final Unit saveBtnEnabled$lambda$8$lambda$7(MediatorLiveData var0, DeviceCreateEditScheduleViewModel var1, Boolean var2) {
      Object var4 = var1.validState.getValue();
      boolean var3 = true;
      if (!Intrinsics.areEqual(var4, true) || var2) {
         var3 = false;
      }

      var0.setValue(var3);
      return Unit.INSTANCE;
   }

   private final DeviceSchedule toDeviceSchedule() {
      Device var2 = this.device;
      if (var2 != null) {
         List var3 = this.buildStartInstructions(var2);
         if (var3.isEmpty()) {
            return null;
         } else {
            String var7 = var2.getUid();
            String var5 = this.getDisplayLabel();
            String var4 = this.timeFormatter.format(this.startTime.getTime());
            Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
            String var8 = this.timeFormatter.format(this.endTime.getTime());
            Intrinsics.checkNotNullExpressionValue(var8, "format(...)");
            boolean var1 = this.paused;
            Set var6 = this.repeat;
            String var9 = this.startTime.getTimeZone().getID();
            Intrinsics.checkNotNullExpressionValue(var9, "getID(...)");
            List var10;
            if (var2 instanceof HasBlueCloudFunctions) {
               var10 = this.buildEndCustomInstructions(var2);
            } else {
               var10 = this.buildLegacyEndInstructions(var2);
            }

            return new DeviceSchedule((String)null, var7, var5, var4, var8, var3, var1, var6, var9, var10, (String)this.scheduleEndType.getValue());
         }
      } else {
         return null;
      }
   }

   private final boolean validateModel() {
      if (!this.repeat.isEmpty() && !Intrinsics.areEqual(this.isStartTimeSameAsEndTime.getValue(), true)) {
         this.validState.setValue(true);
         return true;
      } else {
         this.validState.setValue(false);
         return false;
      }
   }

   public final void delete(Function1 var1) {
      Intrinsics.checkNotNullParameter(var1, "onComplete");
      State var3 = this.state;
      State var4 = DeviceCreateEditScheduleViewModel.State.MODIFY;
      Boolean var2 = false;
      if (var3 != var4) {
         var1.invoke(var2);
      } else {
         DeviceScheduleMerged var6 = this.editingSchedule;
         Device var5 = this.device;
         if (var6 == null) {
            var1.invoke(var2);
         } else if (var5 == null) {
            var1.invoke(var2);
         } else {
            BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, (CoroutineContext)null, (CoroutineStart)null, new Function2(this, var5, var6, var1, (Continuation)null) {
               final Device $device;
               final Function1 $onComplete;
               final DeviceScheduleMerged $scheduleToDelete;
               int label;
               final DeviceCreateEditScheduleViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$device = var2;
                  this.$scheduleToDelete = var3;
                  this.$onComplete = var4;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$device, this.$scheduleToDelete, this.$onComplete, var2));
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
                     DeviceScheduleService var5 = this.this$0.getDeviceScheduleService();
                     var1 = this.$device;
                     DeviceScheduleMerged var6 = this.$scheduleToDelete;
                     Continuation var4 = (Continuation)this;
                     this.label = 1;
                     if (var5.deleteMergedSchedule(var1, var6, var4) == var3) {
                        return var3;
                     }
                  }

                  this.$onComplete.invoke(Boxing.boxBoolean(true));
                  return Unit.INSTANCE;
               }
            }, 3, (Object)null);
         }
      }
   }

   public final FanSpeedEnum getDefaultFanSpeed() {
      return this.defaultFanSpeed;
   }

   public final String getDefaultLabel() {
      return (String)this.defaultLabel$delegate.getValue();
   }

   public final PurifierMode getDefaultPurifierMode() {
      return this.defaultPurifierMode;
   }

   public final Device getDevice() {
      return this.device;
   }

   public final String getDisplayEndTime() {
      SimpleDateFormat var2 = this.currentTimeFormatter;
      SimpleDateFormat var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentTimeFormatter");
         var1 = null;
      }

      String var3 = var1.format(this.endTime.getTime());
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      return var3;
   }

   public final String getDisplayLabel() {
      CharSequence var2 = (CharSequence)this.label;
      Object var1 = var2;
      if (StringsKt.isBlank(var2)) {
         var1 = this.getDefaultLabel();
      }

      return (String)var1;
   }

   public final String getDisplayRepeat() {
      Application var1 = this.getApplication();
      String var3;
      if (DayOfWeekExtensionKt.isWeekendOnly(DayOfWeek.Companion, this.repeat)) {
         var3 = var1.getApplicationContext().getString(R.string.weekend);
      } else if (DayOfWeekExtensionKt.isWeekdaysOnly(DayOfWeek.Companion, this.repeat)) {
         var3 = var1.getApplicationContext().getString(R.string.weekdays);
      } else if (DayOfWeekExtensionKt.isEveryDay(DayOfWeek.Companion, this.repeat)) {
         var3 = var1.getApplicationContext().getString(R.string.everyday);
      } else {
         var3 = CollectionsKt.joinToString$default((Iterable)CollectionsKt.sortedWith((Iterable)this.repeat, new Comparator() {
            public final int compare(Object var1, Object var2) {
               return ComparisonsKt.compareValues((Comparable)((DayOfWeek)var1).getDbValue(), (Comparable)((DayOfWeek)var2).getDbValue());
            }
         }), (CharSequence)", ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, new DeviceCreateEditScheduleViewModel$$ExternalSyntheticLambda5(var1), 30, (Object)null);
      }

      Intrinsics.checkNotNull(var3);
      StringBuilder var2 = new StringBuilder();
      var2.append(var3);
      var2.append(' ');
      var2.append(this.getDisplayStartTime());
      var2.append(" - ");
      var2.append(this.getDisplayEndTime());
      return var2.toString();
   }

   public final String getDisplayStartTime() {
      SimpleDateFormat var2 = this.currentTimeFormatter;
      SimpleDateFormat var1 = var2;
      if (var2 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("currentTimeFormatter");
         var1 = null;
      }

      String var3 = var1.format(this.startTime.getTime());
      Intrinsics.checkNotNullExpressionValue(var3, "format(...)");
      return var3;
   }

   public final DeviceScheduleMerged getEditingSchedule() {
      return this.editingSchedule;
   }

   public final Object getEndBrightness() {
      return this.endBrightness;
   }

   public final FanSpeedEnum getEndFanSpeed() {
      return this.endFanSpeed;
   }

   public final Calendar getEndTime() {
      return this.endTime;
   }

   public final String getLabel() {
      return this.label;
   }

   public final MutableLiveData getLiveDevice() {
      return this.liveDevice;
   }

   public final MutableLiveData getLiveMainMode() {
      return this.liveMainMode;
   }

   public final MutableLiveData getLivePurifierMode() {
      return this.livePurifierMode;
   }

   public final MutableLiveData getLiveScheduleEndCustomFanSpeed() {
      return this.liveScheduleEndCustomFanSpeed;
   }

   public final MutableLiveData getLiveScheduleEndCustomMainMode() {
      return this.liveScheduleEndCustomMainMode;
   }

   public final MutableLiveData getLiveScheduleEndCustomMode() {
      return this.liveScheduleEndCustomMode;
   }

   public final MutableLiveData getLiveStartFanSpeed() {
      return this.liveStartFanSpeed;
   }

   public final boolean getPaused() {
      return this.paused;
   }

   public final PurifierMode getPurifierMode() {
      return this.purifierMode;
   }

   public final Set getRepeat() {
      return this.repeat;
   }

   public final MutableLiveData getRequesting() {
      return this.requesting;
   }

   public final MediatorLiveData getSaveBtnEnabled() {
      return this.saveBtnEnabled;
   }

   public final ApSubMode getScheduleEndCustomApSubMode() {
      return this.scheduleEndCustomApSubMode;
   }

   public final int getScheduleEndCustomAutoRh() {
      return this.scheduleEndCustomAutoRh;
   }

   public final Object getScheduleEndCustomBrightness() {
      return this.scheduleEndCustomBrightness;
   }

   public final FanSpeedEnum getScheduleEndCustomFanSpeed() {
      return this.scheduleEndCustomFanSpeed;
   }

   public final double getScheduleEndCustomHeatAutoTemp() {
      return this.scheduleEndCustomHeatAutoTemp;
   }

   public final double getScheduleEndCustomHeatEcoTemp() {
      return this.scheduleEndCustomHeatEcoTemp;
   }

   public final boolean getScheduleEndCustomHumMode() {
      return this.scheduleEndCustomHumMode;
   }

   public final MainMode getScheduleEndCustomMainMode() {
      return this.scheduleEndCustomMainMode;
   }

   public final PurifierMode getScheduleEndCustomMode() {
      return this.scheduleEndCustomMode;
   }

   public final boolean getScheduleEndCustomOscillationEnabled() {
      return this.scheduleEndCustomOscillationEnabled;
   }

   public final SmartSubMode getScheduleEndCustomSmartSubMode() {
      return this.scheduleEndCustomSmartSubMode;
   }

   public final MutableLiveData getScheduleEndType() {
      return this.scheduleEndType;
   }

   public final boolean getScheduleEndTypeHintClosedBefore() {
      Prefs var3;
      String var4;
      label11: {
         var3 = this.getPrefs();
         Device var1 = this.device;
         if (var1 != null) {
            String var2 = var1.getUid();
            var4 = var2;
            if (var2 != null) {
               break label11;
            }
         }

         var4 = "";
      }

      var4 = String.format("KEY_SCHEDULE_END_TYPE_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{var4}, 1));
      Intrinsics.checkNotNullExpressionValue(var4, "format(...)");
      return (Boolean)PreferencesHelper.INSTANCE.get(var3.getBackend(), var4, false, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final ApSubMode getStartApSubMode() {
      return this.startApSubMode;
   }

   public final int getStartAutoRh() {
      return this.startAutoRh;
   }

   public final Object getStartBrightness() {
      return this.startBrightness;
   }

   public final FanSpeedEnum getStartFanSpeed() {
      return this.startFanSpeed;
   }

   public final double getStartHeatAutoTemp() {
      return this.startHeatAutoTemp;
   }

   public final double getStartHeatEcoTemp() {
      return this.startHeatEcoTemp;
   }

   public final boolean getStartHumMode() {
      return this.startHumMode;
   }

   public final MainMode getStartMainMode() {
      return this.startMainMode;
   }

   public final boolean getStartOscillationEnabled() {
      return this.startOscillationEnabled;
   }

   public final SmartSubMode getStartSmartSubMode() {
      return this.startSmartSubMode;
   }

   public final Calendar getStartTime() {
      return this.startTime;
   }

   public final State getState() {
      return this.state;
   }

   public final String getTitle() {
      State var2 = this.state;
      int var1 = DeviceCreateEditScheduleViewModel.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
      if (var1 != 1) {
         if (var1 == 2) {
            String var4 = this.getApplication().getString(R.string.modify_schedule);
            Intrinsics.checkNotNullExpressionValue(var4, "getString(...)");
            return var4;
         } else {
            throw new NoWhenBranchMatchedException();
         }
      } else {
         String var3 = this.getApplication().getString(R.string.new_schedule);
         Intrinsics.checkNotNullExpressionValue(var3, "getString(...)");
         return var3;
      }
   }

   public final MutableLiveData getValidState() {
      return this.validState;
   }

   public final void initTimeFormat(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      String var2;
      if (DateFormat.is24HourFormat(var1)) {
         var2 = "HH:mm";
      } else {
         var2 = "hh:mm a";
      }

      this.currentTimeFormatter = new SimpleDateFormat(var2);
   }

   public final MutableLiveData isStartTimeSameAsEndTime() {
      return this.isStartTimeSameAsEndTime;
   }

   public final void onComplete(Function2 var1) {
      Intrinsics.checkNotNullParameter(var1, "onComplete");
      this.requesting.setValue(true);
      if (!this.validateModel()) {
         onComplete$_onComplete(this, var1, false, false);
      } else {
         Device var2 = this.device;
         if (var2 != null) {
            BuildersKt.launch$default(ViewModelKt.getViewModelScope((ViewModel)this), (CoroutineContext)Dispatchers.getIO(), (CoroutineStart)null, new Function2(this, var2, var1, (Continuation)null) {
               final Device $it;
               final Function2 $onComplete;
               Object L$0;
               Object L$1;
               Object L$2;
               int label;
               final DeviceCreateEditScheduleViewModel this$0;

               {
                  this.this$0 = var1;
                  this.$it = var2;
                  this.$onComplete = var3;
               }

               public final Continuation create(Object var1, Continuation var2) {
                  return (Continuation)(new <anonymous constructor>(this.this$0, this.$it, this.$onComplete, var2));
               }

               public final Object invoke(CoroutineScope var1, Continuation var2) {
                  return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
               }

               public final Object invokeSuspend(Object var1) {
                  DeviceSchedule var5;
                  Object var7;
                  List var16;
                  label78: {
                     label79: {
                        var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                           case 0:
                              ResultKt.throwOnFailure(var1);
                              var17 = this.this$0.toDeviceSchedule();
                              if (var17 == null) {
                                 return Unit.INSTANCE;
                              }

                              var1 = this.this$0.getDeviceScheduleService();
                              String var23 = var17.getDeviceId();
                              boolean var3 = this.$it instanceof HasBlueCloudFunctions;
                              Continuation var21 = (Continuation)this;
                              this.L$0 = var17;
                              this.label = 1;
                              Object var22 = var1.getSchedulesFor(var23, var3 ^ true, var21);
                              var1 = (DeviceScheduleService)var22;
                              if (var22 == var7) {
                                 return var7;
                              }
                              break;
                           case 1:
                              var17 = (DeviceSchedule)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              break;
                           case 2:
                              var16 = (List)this.L$1;
                              DeviceSchedule var19 = (DeviceSchedule)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           case 3:
                              var20 = (List)this.L$1;
                              var17 = (DeviceSchedule)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              break label79;
                           case 4:
                           case 5:
                              Device var6 = (Device)this.L$2;
                              var16 = (List)this.L$1;
                              var5 = (DeviceSchedule)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              var1 = var6;
                              break label78;
                           case 6:
                              Device var4 = (Device)this.L$2;
                              List var14 = (List)this.L$1;
                              DeviceSchedule var15 = (DeviceSchedule)this.L$0;
                              ResultKt.throwOnFailure(var1);
                              return Unit.INSTANCE;
                           default:
                              throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }

                        var20 = (List)var1;
                        if (this.this$0.hasOverlap(var20)) {
                           CoroutineContext var31 = (CoroutineContext)Dispatchers.getMain();
                           Function2 var35 = new Function2(this.this$0, this.$onComplete, (Continuation)null) {
                              final Function2 $onComplete;
                              int label;
                              final DeviceCreateEditScheduleViewModel this$0;

                              {
                                 this.this$0 = var1;
                                 this.$onComplete = var2;
                              }

                              public final Continuation create(Object var1, Continuation var2) {
                                 return (Continuation)(new <anonymous constructor>(this.this$0, this.$onComplete, var2));
                              }

                              public final Object invoke(CoroutineScope var1, Continuation var2) {
                                 return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                              }

                              public final Object invokeSuspend(Object var1) {
                                 IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                 if (this.label == 0) {
                                    ResultKt.throwOnFailure(var1);
                                    DeviceCreateEditScheduleViewModel.onComplete$_onComplete(this.this$0, this.$onComplete, true, false);
                                    return Unit.INSTANCE;
                                 } else {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                 }
                              }
                           };
                           Continuation var13 = (Continuation)this;
                           this.L$0 = SpillingKt.nullOutSpilledVariable(var17);
                           this.L$1 = SpillingKt.nullOutSpilledVariable(var20);
                           this.label = 2;
                           if (BuildersKt.withContext(var31, var35, var13) != var7) {
                              return Unit.INSTANCE;
                           }

                           return var7;
                        }

                        DeviceManager var24 = this.this$0.getDeviceManager();
                        String var8 = this.$it.getUid();
                        Continuation var12 = (Continuation)this;
                        this.L$0 = var17;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(var20);
                        this.label = 3;
                        var1 = (DeviceScheduleService)var24.getDatabaseDevice(var8, var12);
                        if (var1 == var7) {
                           return var7;
                        }
                     }

                     Device var25 = (Device)var1;
                     var1 = var25;
                     if (var25 == null) {
                        var1 = this.$it;
                     }

                     State var26 = this.this$0.getState();
                     int var2 = null.WhenMappings.$EnumSwitchMapping$0[var26.ordinal()];
                     if (var2 != 1) {
                        if (var2 != 2) {
                           throw new NoWhenBranchMatchedException();
                        }

                        DeviceScheduleService var27 = this.this$0.getDeviceScheduleService();
                        Continuation var32 = (Continuation)this;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var17);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(var20);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        this.label = 5;
                        if (var27.createSchedule(var1, var17, var32) == var7) {
                           return var7;
                        }
                     } else {
                        DeviceScheduleService var9 = this.this$0.getDeviceScheduleService();
                        DeviceScheduleMerged var28 = this.this$0.getEditingSchedule();
                        Continuation var33 = (Continuation)this;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(var17);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(var20);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(var1);
                        this.label = 4;
                        if (var9.updateSchedule(var1, var17, var28, var33) == var7) {
                           return var7;
                        }
                     }

                     DeviceSchedule var29 = var17;
                     var16 = var20;
                     var5 = var29;
                  }

                  CoroutineContext var34 = (CoroutineContext)Dispatchers.getMain();
                  Function2 var36 = new Function2(this.this$0, this.$onComplete, (Continuation)null) {
                     final Function2 $onComplete;
                     int label;
                     final DeviceCreateEditScheduleViewModel this$0;

                     {
                        this.this$0 = var1;
                        this.$onComplete = var2;
                     }

                     public final Continuation create(Object var1, Continuation var2) {
                        return (Continuation)(new <anonymous constructor>(this.this$0, this.$onComplete, var2));
                     }

                     public final Object invoke(CoroutineScope var1, Continuation var2) {
                        return ((<undefinedtype>)this.create(var1, var2)).invokeSuspend(Unit.INSTANCE);
                     }

                     public final Object invokeSuspend(Object var1) {
                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                           ResultKt.throwOnFailure(var1);
                           DeviceCreateEditScheduleViewModel.onComplete$_onComplete(this.this$0, this.$onComplete, false, true);
                           return Unit.INSTANCE;
                        } else {
                           throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                     }
                  };
                  Continuation var30 = (Continuation)this;
                  this.L$0 = SpillingKt.nullOutSpilledVariable(var5);
                  this.L$1 = SpillingKt.nullOutSpilledVariable(var16);
                  this.L$2 = SpillingKt.nullOutSpilledVariable(var1);
                  this.label = 6;
                  if (BuildersKt.withContext(var34, var36, var30) == var7) {
                     return var7;
                  } else {
                     return Unit.INSTANCE;
                  }
               }

               // $FF: synthetic class
               @Metadata(
                  k = 3,
                  mv = {2, 2, 0},
                  xi = 48
               )
               public static final class WhenMappings {
                  public static final int[] $EnumSwitchMapping$0;

                  static {
                     int[] var0 = new int[DeviceCreateEditScheduleViewModel.State.values().length];

                     try {
                        var0[DeviceCreateEditScheduleViewModel.State.MODIFY.ordinal()] = 1;
                     } catch (NoSuchFieldError var3) {
                     }

                     try {
                        var0[DeviceCreateEditScheduleViewModel.State.NEW.ordinal()] = 2;
                     } catch (NoSuchFieldError var2) {
                     }

                     $EnumSwitchMapping$0 = var0;
                  }
               }
            }, 2, (Object)null);
         }

      }
   }

   public final void setDevice(Device var1) {
      this.device = var1;
      if (var1 != null) {
         this.liveDevice.setValue(var1);
         PurifierMode var2;
         if (var1 instanceof DevicePet20) {
            this.setScheduleEndCustomMode(DeviceCreateEditScheduleViewModel.PurifierMode.SMART);
            var2 = DeviceCreateEditScheduleViewModel.PurifierMode.SMART;
         } else if (var1 instanceof DeviceMiniRestful) {
            var2 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
         } else if (var1 instanceof HasFanSpeed && ((HasFanSpeed)var1).getAutoMode() != AutoMode.NOT_AVAILABLE) {
            var2 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
         } else if (var1 instanceof HasLinkingCapability && ((HasLinkingCapability)var1).isLinked()) {
            var2 = DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
         } else {
            var2 = DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
         }

         this.defaultPurifierMode = var2;
         this.setPurifierMode(var2);
         this.setScheduleEndCustomMode(this.defaultPurifierMode);
         Device var4 = this.device;
         if (var4 instanceof DeviceHumidifier20 || var4 instanceof DeviceMiniRestful || var4 instanceof DevicePet20 || var4 instanceof DeviceCombo2in120) {
            FanSpeedEnum var5 = FanSpeedEnum.ELEVEN;
            this.defaultFanSpeed = var5;
            this.setStartFanSpeed(var5);
            this.setScheduleEndCustomFanSpeed(this.defaultFanSpeed);
         }

         MainMode var3;
         if (var1 instanceof DeviceDehumidifier) {
            this.setScheduleEndCustomMainMode(MainMode.Dehumidification);
            var3 = MainMode.Dehumidification;
         } else {
            var3 = MainMode.AirPurify;
         }

         this.setStartMainMode(var3);
      }

   }

   public final void setEditingSchedule(DeviceScheduleMerged var1) {
      this.editingSchedule = var1;
      if (var1 != null) {
         this.configureForModify(var1);
      }

   }

   public final void setEndBrightness(Object var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.endBrightness = var1;
   }

   public final void setEndFanSpeed(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.endFanSpeed = var1;
   }

   public final void setEndTime(Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.endTime = var1;
      this.isStartTimeSameAsEndTime.setValue(this.isStartTimeSameAsEndTime());
      this.validateModel();
   }

   public final void setLabel(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.label = var1;
   }

   public final void setLiveDevice(MutableLiveData var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.liveDevice = var1;
   }

   public final void setPaused(boolean var1) {
      this.paused = var1;
   }

   public final void setPurifierMode(PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.purifierMode = var1;
      if (var1 == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION) {
         this.setStartTime(this.startTime);
      }

      this.livePurifierMode.setValue(var1);
   }

   public final void setRepeat(Set var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.repeat = var1;
      this.validateModel();
   }

   public final void setScheduleEndCustomApSubMode(ApSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (this.scheduleEndCustomApSubMode != var1) {
         this.scheduleEndCustomApSubMode = var1;
         if (this.scheduleEndCustomMode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            this.setScheduleEndCustomMode(DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromSubMode(var1));
         }
      }

   }

   public final void setScheduleEndCustomAutoRh(int var1) {
      this.scheduleEndCustomAutoRh = var1;
   }

   public final void setScheduleEndCustomBrightness(Object var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.scheduleEndCustomBrightness = var1;
   }

   public final void setScheduleEndCustomFanSpeed(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.scheduleEndCustomFanSpeed = var1;
      this.liveScheduleEndCustomFanSpeed.setValue(var1);
   }

   public final void setScheduleEndCustomHeatAutoTemp(double var1) {
      this.scheduleEndCustomHeatAutoTemp = var1;
   }

   public final void setScheduleEndCustomHeatEcoTemp(double var1) {
      this.scheduleEndCustomHeatEcoTemp = var1;
   }

   public final void setScheduleEndCustomHumMode(boolean var1) {
      this.scheduleEndCustomHumMode = var1;
   }

   public final void setScheduleEndCustomMainMode(MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.scheduleEndCustomMainMode = var1;
      this.liveScheduleEndCustomMainMode.setValue(var1);
   }

   public final void setScheduleEndCustomMode(PurifierMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.scheduleEndCustomMode = var1;
      this.liveScheduleEndCustomMode.setValue(var1);
   }

   public final void setScheduleEndCustomOscillationEnabled(boolean var1) {
      this.scheduleEndCustomOscillationEnabled = var1;
   }

   public final void setScheduleEndCustomSmartSubMode(SmartSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.scheduleEndCustomSmartSubMode = var1;
   }

   public final void setScheduleEndTypeHintClosedBefore(boolean var1) {
      Prefs var4;
      String var5;
      label11: {
         var4 = this.getPrefs();
         Device var2 = this.device;
         if (var2 != null) {
            String var3 = var2.getUid();
            var5 = var3;
            if (var3 != null) {
               break label11;
            }
         }

         var5 = "";
      }

      var5 = String.format("KEY_SCHEDULE_END_TYPE_HINT_CLOSED_BEFORE_%s", Arrays.copyOf(new Object[]{var5}, 1));
      Intrinsics.checkNotNullExpressionValue(var5, "format(...)");
      PreferencesHelper.INSTANCE.set(var4.getBackend(), var5, var1, Reflection.getOrCreateKotlinClass(Boolean.class));
   }

   public final void setStartApSubMode(ApSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      if (this.startApSubMode != var1) {
         this.startApSubMode = var1;
         if (this.purifierMode != DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY) {
            this.setPurifierMode(DeviceCreateEditScheduleViewModel.PurifierMode.Companion.fromSubMode(var1));
         }
      }

   }

   public final void setStartAutoRh(int var1) {
      this.startAutoRh = var1;
   }

   public final void setStartBrightness(Object var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.startBrightness = var1;
   }

   public final void setStartFanSpeed(FanSpeedEnum var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.startFanSpeed = var1;
      this.liveStartFanSpeed.setValue(var1);
   }

   public final void setStartHeatAutoTemp(double var1) {
      this.startHeatAutoTemp = var1;
   }

   public final void setStartHeatEcoTemp(double var1) {
      this.startHeatEcoTemp = var1;
   }

   public final void setStartHumMode(boolean var1) {
      this.startHumMode = var1;
   }

   public final void setStartMainMode(MainMode var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.startMainMode = var1;
      this.liveMainMode.setValue(var1);
   }

   public final void setStartOscillationEnabled(boolean var1) {
      this.startOscillationEnabled = var1;
   }

   public final void setStartSmartSubMode(SmartSubMode var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.startSmartSubMode = var1;
   }

   public final void setStartTime(Calendar var1) {
      Intrinsics.checkNotNullParameter(var1, "value");
      this.startTime = var1;
      if (this.purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION) {
         Object var2 = var1.clone();
         Intrinsics.checkNotNull(var2, "null cannot be cast to non-null type java.util.Calendar");
         Calendar var3 = (Calendar)var2;
         var3.add(13, 7200);
         this.setEndTime(var3);
      }

      this.isStartTimeSameAsEndTime.setValue(this.isStartTimeSameAsEndTime());
      this.validateModel();
   }

   public final void setState(State var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.state = var1;
   }

   @Metadata(
      d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0013"},
      d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "", "<init>", "(Ljava/lang/String;I)V", "STANDBY", "AUTO", "MANUAL", "NIGHT", "DISINFECTION", "ECO", "SKIN", "SMART", "DRYING", "CONTINUOUS", "toModeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum PurifierMode {
      private static final EnumEntries $ENTRIES;
      private static final PurifierMode[] $VALUES;
      AUTO,
      CONTINUOUS;

      public static final Companion Companion;
      DISINFECTION,
      DRYING,
      ECO,
      MANUAL,
      NIGHT,
      SKIN,
      SMART,
      STANDBY;

      // $FF: synthetic method
      private static final PurifierMode[] $values() {
         return new PurifierMode[]{STANDBY, AUTO, MANUAL, NIGHT, DISINFECTION, ECO, SKIN, SMART, DRYING, CONTINUOUS};
      }

      static {
         PurifierMode[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
         Companion = new Companion((DefaultConstructorMarker)null);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }

      public final ModeIcon toModeIcon(Device var1) {
         Intrinsics.checkNotNullParameter(var1, "device");
         switch (DeviceCreateEditScheduleViewModel.PurifierMode.WhenMappings.$EnumSwitchMapping$0[this.ordinal()]) {
            case 1:
               return ModeIcon.STANDBY;
            case 2:
               return ModeIcon.AUTO.proofread(var1);
            case 3:
               return ModeIcon.FAN_SPEED;
            case 4:
               return ModeIcon.NIGHT;
            case 5:
               return ModeIcon.DISINFECTION;
            case 6:
               return ModeIcon.ECO;
            case 7:
               return ModeIcon.SMART;
            case 8:
               return ModeIcon.DRYING.proofread(var1);
            case 9:
               return ModeIcon.CONTINUOUS;
            case 10:
               return ModeIcon.SKIN;
            default:
               throw new NoWhenBranchMatchedException();
         }
      }

      @Metadata(
         d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\f¨\u0006\r"},
         d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode$Companion;", "", "<init>", "()V", "fromModeIcon", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "modeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "fromSubMode", "subMode", "Lcom/blueair/core/model/ApSubMode;", "fromHumSubMode", "Lcom/blueair/core/model/HumSubMode;", "devicedetails_otherRelease"},
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

         public final PurifierMode fromHumSubMode(HumSubMode var1) {
            Intrinsics.checkNotNullParameter(var1, "subMode");
            int var2 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.WhenMappings.$EnumSwitchMapping$2[var1.ordinal()];
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     if (var2 == 4) {
                        return DeviceCreateEditScheduleViewModel.PurifierMode.SKIN;
                     } else {
                        throw new NoWhenBranchMatchedException();
                     }
                  } else {
                     return DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
                  }
               } else {
                  return DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
               }
            } else {
               return DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
            }
         }

         public final PurifierMode fromModeIcon(ModeIcon var1) {
            Intrinsics.checkNotNullParameter(var1, "modeIcon");
            switch (DeviceCreateEditScheduleViewModel.PurifierMode.Companion.WhenMappings.$EnumSwitchMapping$0[var1.ordinal()]) {
               case 1:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
               case 2:
               case 3:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
               case 4:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
               case 5:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.ECO;
               case 6:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
               case 7:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION;
               case 8:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.SMART;
               case 9:
               case 10:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.DRYING;
               case 11:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS;
               case 12:
                  return DeviceCreateEditScheduleViewModel.PurifierMode.SKIN;
               default:
                  return null;
            }
         }

         public final PurifierMode fromSubMode(ApSubMode var1) {
            Intrinsics.checkNotNullParameter(var1, "subMode");
            int var2 = DeviceCreateEditScheduleViewModel.PurifierMode.Companion.WhenMappings.$EnumSwitchMapping$1[var1.ordinal()];
            if (var2 != 1) {
               if (var2 != 2) {
                  if (var2 != 3) {
                     if (var2 == 4) {
                        return DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
                     } else {
                        throw new NoWhenBranchMatchedException();
                     }
                  } else {
                     return DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
                  }
               } else {
                  return DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
               }
            } else {
               return DeviceCreateEditScheduleViewModel.PurifierMode.ECO;
            }
         }

         // $FF: synthetic class
         @Metadata(
            k = 3,
            mv = {2, 2, 0},
            xi = 48
         )
         public static final class WhenMappings {
            public static final int[] $EnumSwitchMapping$0;
            public static final int[] $EnumSwitchMapping$1;
            public static final int[] $EnumSwitchMapping$2;

            static {
               int[] var0 = new int[ModeIcon.values().length];

               try {
                  var0[ModeIcon.FAN_SPEED.ordinal()] = 1;
               } catch (NoSuchFieldError var21) {
               }

               try {
                  var0[ModeIcon.AUTO.ordinal()] = 2;
               } catch (NoSuchFieldError var20) {
               }

               try {
                  var0[ModeIcon.WATERDROP_AUTO.ordinal()] = 3;
               } catch (NoSuchFieldError var19) {
               }

               try {
                  var0[ModeIcon.NIGHT.ordinal()] = 4;
               } catch (NoSuchFieldError var18) {
               }

               try {
                  var0[ModeIcon.ECO.ordinal()] = 5;
               } catch (NoSuchFieldError var17) {
               }

               try {
                  var0[ModeIcon.STANDBY.ordinal()] = 6;
               } catch (NoSuchFieldError var16) {
               }

               try {
                  var0[ModeIcon.DISINFECTION.ordinal()] = 7;
               } catch (NoSuchFieldError var15) {
               }

               try {
                  var0[ModeIcon.SMART.ordinal()] = 8;
               } catch (NoSuchFieldError var14) {
               }

               try {
                  var0[ModeIcon.DRYING.ordinal()] = 9;
               } catch (NoSuchFieldError var13) {
               }

               try {
                  var0[ModeIcon.BOOST.ordinal()] = 10;
               } catch (NoSuchFieldError var12) {
               }

               try {
                  var0[ModeIcon.CONTINUOUS.ordinal()] = 11;
               } catch (NoSuchFieldError var11) {
               }

               try {
                  var0[ModeIcon.SKIN.ordinal()] = 12;
               } catch (NoSuchFieldError var10) {
               }

               $EnumSwitchMapping$0 = var0;
               var0 = new int[ApSubMode.values().length];

               try {
                  var0[ApSubMode.ECO.ordinal()] = 1;
               } catch (NoSuchFieldError var9) {
               }

               try {
                  var0[ApSubMode.FAN.ordinal()] = 2;
               } catch (NoSuchFieldError var8) {
               }

               try {
                  var0[ApSubMode.AUTO.ordinal()] = 3;
               } catch (NoSuchFieldError var7) {
               }

               try {
                  var0[ApSubMode.NIGHT.ordinal()] = 4;
               } catch (NoSuchFieldError var6) {
               }

               $EnumSwitchMapping$1 = var0;
               var0 = new int[HumSubMode.values().length];

               try {
                  var0[HumSubMode.FAN.ordinal()] = 1;
               } catch (NoSuchFieldError var5) {
               }

               try {
                  var0[HumSubMode.AUTO.ordinal()] = 2;
               } catch (NoSuchFieldError var4) {
               }

               try {
                  var0[HumSubMode.NIGHT.ordinal()] = 3;
               } catch (NoSuchFieldError var3) {
               }

               try {
                  var0[HumSubMode.SKIN.ordinal()] = 4;
               } catch (NoSuchFieldError var2) {
               }

               $EnumSwitchMapping$2 = var0;
            }
         }
      }

      // $FF: synthetic class
      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WhenMappings {
         public static final int[] $EnumSwitchMapping$0;

         static {
            int[] var0 = new int[DeviceCreateEditScheduleViewModel.PurifierMode.values().length];

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY.ordinal()] = 1;
            } catch (NoSuchFieldError var11) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.AUTO.ordinal()] = 2;
            } catch (NoSuchFieldError var10) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL.ordinal()] = 3;
            } catch (NoSuchFieldError var9) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError var8) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION.ordinal()] = 5;
            } catch (NoSuchFieldError var7) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.ECO.ordinal()] = 6;
            } catch (NoSuchFieldError var6) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.SMART.ordinal()] = 7;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.DRYING.ordinal()] = 8;
            } catch (NoSuchFieldError var4) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS.ordinal()] = 9;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[DeviceCreateEditScheduleViewModel.PurifierMode.SKIN.ordinal()] = 10;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }

   @Metadata(
      d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"},
      d2 = {"Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$State;", "", "<init>", "(Ljava/lang/String;I)V", "NEW", "MODIFY", "devicedetails_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static enum State {
      private static final EnumEntries $ENTRIES;
      private static final State[] $VALUES;
      MODIFY,
      NEW;

      // $FF: synthetic method
      private static final State[] $values() {
         return new State[]{NEW, MODIFY};
      }

      static {
         State[] var0 = $values();
         $VALUES = var0;
         $ENTRIES = EnumEntriesKt.enumEntries(var0);
      }

      public static EnumEntries getEntries() {
         return $ENTRIES;
      }
   }

   // $FF: synthetic class
   @Metadata(
      k = 3,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class WhenMappings {
      public static final int[] $EnumSwitchMapping$0;
      public static final int[] $EnumSwitchMapping$1;
      public static final int[] $EnumSwitchMapping$2;
      public static final int[] $EnumSwitchMapping$3;
      public static final int[] $EnumSwitchMapping$4;
      public static final int[] $EnumSwitchMapping$5;

      static {
         int[] var0 = new int[DeviceCreateEditScheduleViewModel.State.values().length];

         try {
            var0[DeviceCreateEditScheduleViewModel.State.NEW.ordinal()] = 1;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.State.MODIFY.ordinal()] = 2;
         } catch (NoSuchFieldError var28) {
         }

         $EnumSwitchMapping$0 = var0;
         var0 = new int[Mode.values().length];

         try {
            var0[Mode.AUTO.ordinal()] = 1;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[Mode.FAN.ordinal()] = 2;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[Mode.NIGHT.ordinal()] = 3;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[Mode.ECO.ordinal()] = 4;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[Mode.SKIN.ordinal()] = 5;
         } catch (NoSuchFieldError var23) {
         }

         $EnumSwitchMapping$1 = var0;
         var0 = new int[DehSubMode.values().length];

         try {
            var0[DehSubMode.DRYING.ordinal()] = 1;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[DehSubMode.AUTO.ordinal()] = 2;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[DehSubMode.CONTINUOUS.ordinal()] = 3;
         } catch (NoSuchFieldError var20) {
         }

         $EnumSwitchMapping$2 = var0;
         var0 = new int[ApSubMode.values().length];

         try {
            var0[ApSubMode.FAN.ordinal()] = 1;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[ApSubMode.NIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[ApSubMode.AUTO.ordinal()] = 3;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[ApSubMode.ECO.ordinal()] = 4;
         } catch (NoSuchFieldError var16) {
         }

         $EnumSwitchMapping$3 = var0;
         var0 = new int[MainMode.values().length];

         try {
            var0[MainMode.Dehumidification.ordinal()] = 1;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[MainMode.AirPurify.ordinal()] = 2;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[MainMode.SMART.ordinal()] = 3;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[MainMode.HEAT.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[MainMode.COOL.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
         }

         $EnumSwitchMapping$4 = var0;
         var0 = new int[DeviceCreateEditScheduleViewModel.PurifierMode.values().length];

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL.ordinal()] = 1;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.DRYING.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.AUTO.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.CONTINUOUS.ordinal()] = 5;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.SMART.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.ECO.ordinal()] = 7;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.SKIN.ordinal()] = 8;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
         }

         $EnumSwitchMapping$5 = var0;
      }
   }
}
