package com.blueair.api.client;

import android.content.res.Resources;
import android.util.Base64;
import com.blueair.api.restapi.ActuatorWrapper;
import com.blueair.api.restapi.AutoModeTrigger;
import com.blueair.api.restapi.BlueCloudRestApi;
import com.blueair.api.restapi.BlueCloudRestApi$_CC;
import com.blueair.api.restapi.BlueDataWrapper;
import com.blueair.api.restapi.G4NightModeTrigger;
import com.blueair.api.restapi.ModeDependency;
import com.blueair.api.restapi.NameConfiguration;
import com.blueair.api.restapi.SimpleResponse;
import com.blueair.api.restapi.UpdateWrapper;
import com.blueair.api.utils.BlueCloudSensor;
import com.blueair.api.utils.RandomString;
import com.blueair.auth.AuthService;
import com.blueair.core.model.BlueDeviceSchedule;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceData;
import com.blueair.core.model.DeviceSchedule;
import com.blueair.core.model.MainMode;
import com.blueair.core.model.WelcomeHomeLocation;
import io.flatcircle.coroutinehelper.ApiResult;
import io.flatcircle.coroutinehelper.Failure;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import timber.log.Timber;

@Metadata(
   d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0013\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 ã\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u00112\u00020\u00122\u00020\u00132\u00020\u00142\u00020\u00152\u00020\u00162\u00020\u00172\u00020\u00182\u00020\u00192\u00020\u001a2\u00020\u001b2\u00020\u001c2\u00020\u001d2\u00020\u001e2\u00020\u001f2\u00020 2\u00020!2\u00020\"2\u00020#2\u00020$:\u0002ã\u0001B+\u0012\u0006\u0010%\u001a\u00020&\u0012\u0006\u0010'\u001a\u00020(\u0012\u0006\u0010)\u001a\u00020*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,¢\u0006\u0004\b-\u0010.J0\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u0010PJ0\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020*2\u0006\u0010Q\u001a\u00020R2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u0010SJ0\u0010I\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010L\u001a\u00020*2\u0006\u0010T\u001a\u00020U2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010*H\u0082@¢\u0006\u0002\u0010VJ\"\u0010W\u001a\b\u0012\u0004\u0012\u00020K0J2\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0YH\u0082@¢\u0006\u0002\u0010[J\u0014\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0JH\u0096@¢\u0006\u0002\u0010^J\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010`\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ&\u0010b\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010c\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010dJ\u001c\u0010e\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010f\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001c\u0010g\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010h\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010k\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ&\u0010l\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010m\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010dJ\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010q\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001c\u0010r\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010s\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ&\u0010t\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010u\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010dJ\u001c\u0010v\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010w\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001c\u0010x\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010y\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001c\u0010z\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u0014\u0010{\u001a\b\u0012\u0004\u0012\u00020K0JH\u0096@¢\u0006\u0002\u0010^J\u001c\u0010|\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001c\u0010}\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001c\u0010~\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001c\u0010\u007f\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ(\u0010\u0081\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0082\u0001\u001a\u00020N2\u0007\u0010\u0083\u0001\u001a\u00020NH\u0096@¢\u0006\u0003\u0010\u0084\u0001J\u001d\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ0\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0088\u0001\u001a\u00020N2\u0007\u0010\u0089\u0001\u001a\u00020N2\u0006\u0010`\u001a\u00020NH\u0096@¢\u0006\u0003\u0010\u008a\u0001J'\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010dJ1\u0010\u008c\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020N2\u0007\u0010\u008d\u0001\u001a\u00020R2\b\u0010O\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0003\u0010\u008e\u0001J\u001d\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010\u0090\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001f\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010o\u001a\u00030\u0093\u0001H\u0096@¢\u0006\u0003\u0010\u0094\u0001J\u001f\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010o\u001a\u00030\u0093\u0001H\u0096@¢\u0006\u0003\u0010\u0094\u0001J\u001d\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ+\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0099\u0001\u001a\u00020N2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0096@¢\u0006\u0003\u0010\u009c\u0001J+\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u0099\u0001\u001a\u00020N2\n\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0096@¢\u0006\u0003\u0010\u009c\u0001J\u001d\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ'\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020N2\b\u0010O\u001a\u0004\u0018\u00010*H\u0096@¢\u0006\u0002\u0010dJ\u001d\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001d\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010£\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u0015\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020K0JH\u0096@¢\u0006\u0002\u0010^J\u001d\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001d\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001d\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ(\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010\u00ad\u0001\u001a\u00020N2\u0007\u0010®\u0001\u001a\u00020NH\u0096@¢\u0006\u0003\u0010\u0084\u0001J+\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010°\u0001\u001a\u00020N2\n\u0010±\u0001\u001a\u0005\u0018\u00010²\u0001H\u0096@¢\u0006\u0003\u0010³\u0001J\u0015\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020K0JH\u0096@¢\u0006\u0002\u0010^J'\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020N2\u0007\u0010¶\u0001\u001a\u00020RH\u0096@¢\u0006\u0003\u0010·\u0001J\u001d\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020RH\u0096@¢\u0006\u0002\u0010iJ\u001d\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u001d\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ'\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010¼\u0001\u001a\u00020R2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0003\u0010½\u0001J:\u0010¾\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010¼\u0001\u001a\u00020R2\u0007\u0010¿\u0001\u001a\u00020N2\u0007\u0010À\u0001\u001a\u00020N2\u0007\u0010Á\u0001\u001a\u00020NH\u0096@¢\u0006\u0003\u0010Â\u0001J1\u0010Ã\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0007\u0010¼\u0001\u001a\u00020R2\u0007\u0010¿\u0001\u001a\u00020N2\u0007\u0010Ä\u0001\u001a\u00020NH\u0096@¢\u0006\u0003\u0010Å\u0001J\u001d\u0010Æ\u0001\u001a\b\u0012\u0004\u0012\u00020K0J2\u0006\u0010o\u001a\u00020NH\u0096@¢\u0006\u0002\u0010aJ\u0016\u0010Ç\u0001\u001a\t\u0012\u0005\u0012\u00030È\u00010JH\u0096@¢\u0006\u0002\u0010^J'\u0010É\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030È\u00010Y0J2\b\u0010Ê\u0001\u001a\u00030Ë\u0001H\u0096@¢\u0006\u0003\u0010Ì\u0001J\u0015\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020U0JH\u0096@¢\u0006\u0002\u0010^J\u001f\u0010Î\u0001\u001a\b\u0012\u0004\u0012\u00020U0J2\u0007\u0010Ï\u0001\u001a\u00020UH\u0096@¢\u0006\u0003\u0010Ð\u0001J\u001f\u0010Ñ\u0001\u001a\b\u0012\u0004\u0012\u00020U0J2\u0007\u0010Ï\u0001\u001a\u00020*H\u0096@¢\u0006\u0003\u0010Ò\u0001J!\u0010Ó\u0001\u001a\t\u0012\u0005\u0012\u00030Ô\u00010J2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0096@¢\u0006\u0003\u0010×\u0001J\u001a\u0010Ø\u0001\u001a\u00030Ù\u00012\u0007\u0010Ú\u0001\u001a\u00020*H\u0096@¢\u0006\u0003\u0010Ò\u0001J\"\u0010Û\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010U0J2\b\u0010Õ\u0001\u001a\u00030Ö\u0001H\u0096@¢\u0006\u0003\u0010×\u0001J\u001c\u0010Ü\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030Ö\u00010Y0JH\u0096@¢\u0006\u0002\u0010^J!\u0010Ý\u0001\u001a\t\u0012\u0005\u0012\u00030Ù\u00010J2\b\u0010Þ\u0001\u001a\u00030ß\u0001H\u0096@¢\u0006\u0003\u0010à\u0001J\u0016\u0010á\u0001\u001a\t\u0012\u0005\u0012\u00030Ù\u00010JH\u0096@¢\u0006\u0002\u0010^J\n\u0010â\u0001\u001a\u00030Ù\u0001H\u0016R\u0014\u0010%\u001a\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001a\u0010'\u001a\u00020(X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u0010)\u001a\u00020*X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010+\u001a\u0004\u0018\u00010,X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001b\u0010;\u001a\u00020<8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\u0014\u0010E\u001a\u00020F8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006ä\u0001"},
   d2 = {"Lcom/blueair/api/client/BlueCloudClient;", "Lcom/blueair/api/client/BlueCloudNetworkClient;", "Lcom/blueair/api/client/CanProvisionCloud;", "Lcom/blueair/api/client/CanSetFan;", "Lcom/blueair/api/client/CanSetChildLock;", "Lcom/blueair/api/client/CanSetBrightness;", "Lcom/blueair/api/client/CanGetSensorData;", "Lcom/blueair/api/client/CanSetStandBy;", "Lcom/blueair/api/client/CanSetG4NightMode;", "Lcom/blueair/api/client/CanSetGermShieldMode;", "Lcom/blueair/api/client/CanSetAutoModeDependency;", "Lcom/blueair/api/client/CanSetDeviceName;", "Lcom/blueair/api/client/CanManageSchedule;", "Lcom/blueair/api/client/CanManageWelcomeHome;", "Lcom/blueair/api/client/CanSetDisinfection;", "Lcom/blueair/api/client/CanSetEcoMode;", "Lcom/blueair/api/client/CanSetHinsMode;", "Lcom/blueair/api/client/CanSetWick;", "Lcom/blueair/api/client/CanSetAutoRh;", "Lcom/blueair/api/client/CanSetTimer;", "Lcom/blueair/api/client/CanSetTemperatureUnit;", "Lcom/blueair/api/client/CanSetOscillation;", "Lcom/blueair/api/client/CanSetMainMode;", "Lcom/blueair/api/client/CanSetMode;", "Lcom/blueair/api/client/CanSetHumMode;", "Lcom/blueair/api/client/CanSetDehSubMode;", "Lcom/blueair/api/client/CanSetSmartSubMode;", "Lcom/blueair/api/client/CanSetTare;", "Lcom/blueair/api/client/CanSetPanelDisplayMode;", "Lcom/blueair/api/client/CanSetHoverEnabled;", "Lcom/blueair/api/client/CanSetAirRefresh;", "Lcom/blueair/api/client/CanSetNightLamp;", "Lcom/blueair/api/client/CanSetYellowWaterRemove;", "Lcom/blueair/api/client/CanSetAlarm;", "Lcom/blueair/api/client/CanSetHumSubMode;", "Lcom/blueair/api/client/CanSetHourFormat;", "Lcom/blueair/api/client/CanSetSensorMode;", "resources", "Landroid/content/res/Resources;", "authService", "Lcom/blueair/auth/AuthService;", "deviceUuid", "", "mockInterceptor", "Lokhttp3/Interceptor;", "<init>", "(Landroid/content/res/Resources;Lcom/blueair/auth/AuthService;Ljava/lang/String;Lokhttp3/Interceptor;)V", "getResources", "()Landroid/content/res/Resources;", "getAuthService", "()Lcom/blueair/auth/AuthService;", "setAuthService", "(Lcom/blueair/auth/AuthService;)V", "getDeviceUuid", "()Ljava/lang/String;", "setDeviceUuid", "(Ljava/lang/String;)V", "getMockInterceptor", "()Lokhttp3/Interceptor;", "okHttpClient", "Lokhttp3/OkHttpClient;", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "Lkotlin/Lazy;", "retrofit", "Lretrofit2/Retrofit;", "getRetrofit", "()Lretrofit2/Retrofit;", "deviceRestApi", "Lcom/blueair/api/restapi/BlueCloudRestApi;", "getDeviceRestApi", "()Lcom/blueair/api/restapi/BlueCloudRestApi;", "setActuator", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "n", "v", "", "type", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vb", "", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "vj", "", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setActuators", "actuators", "", "Lcom/blueair/api/restapi/ActuatorWrapper;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRandomVerifyText", "Lcom/blueair/api/client/RandomVerifyText;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setFanSpeed", "fanSpeed", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoMode", "enabled", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setChildLock", "isLocked", "setDisinfection", "disinfection", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBrightness", "brightness", "setStandBy", "isStandBy", "setEcoMode", "value", "setHinsMode", "isHinsModeOn", "setHinsNightMode", "isHinsNightModeOn", "setG4NightMode", "isG4NightMode", "setGermShieldMode", "isGermShieldMode", "setGermShieldNightMode", "isGermShieldNightModeOn", "setWickDryEnabled", "cancelWickDryMode", "setWickDryOn", "setWickDryDurationAndOn", "setAutoRh", "setTimerStatus", "setTimerDuration", "setTimerDurationAndStatus", "duration", "status", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setTemperatureUnit", "setOscillationState", "setOscillationParams", "angle", "direction", "(IIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMainMode", "setApSubMode", "overwriteMainMode", "(IZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setApFanSpeed", "setHeatSubMode", "setHeatFanSpeed", "setHeatAutoTmp", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setHeatEcoTmp", "setCoolSubMode", "setCoolFanSpeed", "setCoolAutoPresets", "tag", "presets", "", "(I[DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCoolEcoPresets", "setCoolFanSpeedLevel", "setCoolAutoLevel", "setMode", "setHumMode", "setDehSubMode", "setSmartSubMode", "setTare", "setPanelDisplayMode", "setHoverEnabled", "setAirRefreshStatus", "setAirRefreshEnabled", "setNightLampBrightness", "setNightLampSteplessBrightness", "setYwrmEnabled", "playAlarm", "sound", "volume", "setAlarm", "index", "alarm", "Lcom/blueair/core/model/DeviceAlarm;", "(ILcom/blueair/core/model/DeviceAlarm;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAlarm", "setHumSubMode", "cancelWickDry", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUse24Hour", "setSensorMode", "calibrateOscillationPosition", "setDualOscillationState", "horizontal", "(ZILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOscillationSwing", "state", "minAngle", "maxAngle", "(ZIIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "configureOscillationFixed", "fixAngle", "(ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOscillationMode", "getLatestSensorPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "getMonthSensorPoints", "fromTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetAutoModeDependency", "setAutoModeDependency", "nuValue", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDeviceName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSchedule", "Lokhttp3/ResponseBody;", "schedule", "Lcom/blueair/core/model/DeviceSchedule;", "(Lcom/blueair/core/model/DeviceSchedule;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteSchedule", "", "scheduleId", "updateSchedule", "getSchedules", "createUpdateWelcomeHome", "location", "Lcom/blueair/core/model/WelcomeHomeLocation;", "(Lcom/blueair/core/model/WelcomeHomeLocation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteWelcomeHome", "clear", "Companion", "api_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class BlueCloudClient implements BlueCloudNetworkClient, CanProvisionCloud, CanSetFan, CanSetChildLock, CanSetBrightness, CanGetSensorData, CanSetStandBy, CanSetG4NightMode, CanSetGermShieldMode, CanSetAutoModeDependency, CanSetDeviceName, CanManageSchedule, CanManageWelcomeHome, CanSetDisinfection, CanSetEcoMode, CanSetHinsMode, CanSetWick, CanSetAutoRh, CanSetTimer, CanSetTemperatureUnit, CanSetOscillation, CanSetMainMode, CanSetMode, CanSetHumMode, CanSetDehSubMode, CanSetSmartSubMode, CanSetTare, CanSetPanelDisplayMode, CanSetHoverEnabled, CanSetAirRefresh, CanSetNightLamp, CanSetYellowWaterRemove, CanSetAlarm, CanSetHumSubMode, CanSetHourFormat, CanSetSensorMode {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private AuthService authService;
   private String deviceUuid;
   private final Interceptor mockInterceptor;
   private final Lazy okHttpClient$delegate;
   private final Resources resources;

   // $FF: synthetic method
   public static OkHttpClient $r8$lambda$AivWp_YbeJb0FmKIZe1qJrjyoW0(BlueCloudClient var0) {
      return okHttpClient_delegate$lambda$0(var0);
   }

   public BlueCloudClient(Resources var1, AuthService var2, String var3, Interceptor var4) {
      Intrinsics.checkNotNullParameter(var1, "resources");
      Intrinsics.checkNotNullParameter(var2, "authService");
      Intrinsics.checkNotNullParameter(var3, "deviceUuid");
      super();
      this.resources = var1;
      this.authService = var2;
      this.deviceUuid = var3;
      this.mockInterceptor = var4;
      this.okHttpClient$delegate = LazyKt.lazy(new BlueCloudClient$$ExternalSyntheticLambda0(this));
   }

   // $FF: synthetic method
   public BlueCloudClient(Resources var1, AuthService var2, String var3, Interceptor var4, int var5, DefaultConstructorMarker var6) {
      if ((var5 & 8) != 0) {
         var4 = null;
      }

      this(var1, var2, var3, var4);
   }

   private static final OkHttpClient okHttpClient_delegate$lambda$0(BlueCloudClient var0) {
      return var0.buildHttpClient(false, var0.getMockInterceptor());
   }

   private final Object setActuator(String var1, int var2, String var3, Continuation var4) {
      label25: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var4;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var14 = var6;
               break label25;
            }
         }

         var14 = new ContinuationImpl(this, var4) {
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setActuator((String)null, 0, (String)null, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var14).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var14).label;
      Companion var9;
      Object var13;
      if (var5 != 0) {
         if (var5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).I$0;
         var9 = (Companion)((<undefinedtype>)var14).L$2;
         String var11 = (String)((<undefinedtype>)var14).L$1;
         var11 = (String)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var15);
         var13 = var15;
      } else {
         ResultKt.throwOnFailure(var15);
         Companion var16 = Companion;
         Deferred var8 = BlueCloudRestApi$_CC.setActuator$default(this.getDeviceRestApi(), this.getDeviceUuid(), new ActuatorWrapper(var1, var2, var3), (String)null, 4, (Object)null);
         ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var3);
         ((<undefinedtype>)var14).L$2 = var16;
         ((<undefinedtype>)var14).I$0 = var2;
         ((<undefinedtype>)var14).label = 1;
         var13 = this.awaitCall(var8, (Continuation)var14);
         if (var13 == var7) {
            return var7;
         }

         var9 = var16;
      }

      return var9.responseBodyToSimpleResponse((ApiResult)var13);
   }

   private final Object setActuator(String var1, Object var2, String var3, Continuation var4) {
      label25: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var4;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var14 = var6;
               break label25;
            }
         }

         var14 = new ContinuationImpl(this, var4) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setActuator((String)null, (Object)null, (String)null, (Continuation)this);
            }
         };
      }

      Object var15 = ((<undefinedtype>)var14).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var14).label;
      Companion var9;
      if (var5 != 0) {
         if (var5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var9 = (Companion)((<undefinedtype>)var14).L$3;
         String var10 = (String)((<undefinedtype>)var14).L$2;
         Object var11 = ((<undefinedtype>)var14).L$1;
         String var12 = (String)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var15);
         var2 = var15;
      } else {
         ResultKt.throwOnFailure(var15);
         Companion var16 = Companion;
         Deferred var8 = BlueCloudRestApi$_CC.setActuator$default(this.getDeviceRestApi(), this.getDeviceUuid(), new ActuatorWrapper(var1, var2, var3), (String)null, 4, (Object)null);
         ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var2);
         ((<undefinedtype>)var14).L$2 = SpillingKt.nullOutSpilledVariable(var3);
         ((<undefinedtype>)var14).L$3 = var16;
         ((<undefinedtype>)var14).label = 1;
         var2 = this.awaitCall(var8, (Continuation)var14);
         if (var2 == var7) {
            return var7;
         }

         var9 = var16;
      }

      return var9.responseBodyToSimpleResponse((ApiResult)var2);
   }

   private final Object setActuator(String var1, boolean var2, String var3, Continuation var4) {
      label25: {
         if (var4 instanceof <undefinedtype>) {
            <undefinedtype> var6 = (<undefinedtype>)var4;
            if ((var6.label & Integer.MIN_VALUE) != 0) {
               var6.label += Integer.MIN_VALUE;
               var14 = var6;
               break label25;
            }
         }

         var14 = new ContinuationImpl(this, var4) {
            Object L$0;
            Object L$1;
            Object L$2;
            boolean Z$0;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setActuator((String)null, false, (String)null, (Continuation)this);
            }
         };
      }

      Object var16 = ((<undefinedtype>)var14).result;
      Object var7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var5 = ((<undefinedtype>)var14).label;
      Companion var9;
      Object var15;
      if (var5 != 0) {
         if (var5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var2 = ((<undefinedtype>)var14).Z$0;
         var9 = (Companion)((<undefinedtype>)var14).L$2;
         var3 = (String)((<undefinedtype>)var14).L$1;
         var3 = (String)((<undefinedtype>)var14).L$0;
         ResultKt.throwOnFailure(var16);
         var15 = var16;
      } else {
         ResultKt.throwOnFailure(var16);
         Companion var17 = Companion;
         Deferred var8 = BlueCloudRestApi$_CC.setActuator$default(this.getDeviceRestApi(), this.getDeviceUuid(), new ActuatorWrapper(var1, var2, var3), (String)null, 4, (Object)null);
         ((<undefinedtype>)var14).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var14).L$1 = SpillingKt.nullOutSpilledVariable(var3);
         ((<undefinedtype>)var14).L$2 = var17;
         ((<undefinedtype>)var14).Z$0 = var2;
         ((<undefinedtype>)var14).label = 1;
         var9 = (Companion)this.awaitCall(var8, (Continuation)var14);
         if (var9 == var7) {
            return var7;
         }

         var15 = var9;
         var9 = var17;
      }

      return var9.responseBodyToSimpleResponse((ApiResult)var15);
   }

   // $FF: synthetic method
   static Object setActuator$default(BlueCloudClient var0, String var1, int var2, String var3, Continuation var4, int var5, Object var6) {
      if ((var5 & 4) != 0) {
         var3 = null;
      }

      return var0.setActuator(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static Object setActuator$default(BlueCloudClient var0, String var1, Object var2, String var3, Continuation var4, int var5, Object var6) {
      if ((var5 & 4) != 0) {
         var3 = null;
      }

      return var0.setActuator(var1, var2, var3, var4);
   }

   // $FF: synthetic method
   static Object setActuator$default(BlueCloudClient var0, String var1, boolean var2, String var3, Continuation var4, int var5, Object var6) {
      if ((var5 & 4) != 0) {
         var3 = null;
      }

      return var0.setActuator(var1, var2, var3, var4);
   }

   private final Object setActuators(List var1, Continuation var2) {
      label25: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var8 = var4;
               break label25;
            }
         }

         var8 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.setActuators((List)null, (Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var8).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var8).label;
      Companion var7;
      Object var10;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var7 = (Companion)((<undefinedtype>)var8).L$1;
         List var9 = (List)((<undefinedtype>)var8).L$0;
         ResultKt.throwOnFailure(var11);
         var10 = var11;
      } else {
         ResultKt.throwOnFailure(var11);
         Companion var12 = Companion;
         Deferred var6 = this.getDeviceRestApi().setActuators(this.getDeviceUuid(), var1);
         ((<undefinedtype>)var8).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var8).L$1 = var12;
         ((<undefinedtype>)var8).label = 1;
         var10 = this.awaitCall(var6, (Continuation)var8);
         if (var10 == var5) {
            return var5;
         }

         var7 = var12;
      }

      return var7.responseBodyToSimpleResponse((ApiResult)var10);
   }

   public Object awaitAllCalls(List var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitAllCalls(this, var1, var2);
   }

   public Object awaitCall(Deferred var1, Continuation var2) {
      return BaseNetworkClient$_CC.$default$awaitCall(this, var1, var2);
   }

   public OkHttpClient buildBasicAuthClient(Interceptor var1) {
      return CloudNetworkClient$_CC.$default$buildBasicAuthClient(this, var1);
   }

   public OkHttpClient buildHttpClient(boolean var1, Interceptor var2) {
      return CloudNetworkClient$_CC.$default$buildHttpClient(this, var1, var2);
   }

   public OkHttpClient buildHttpClientWithFakeUserSupport(boolean var1, Interceptor var2) {
      return CloudNetworkClient$_CC.$default$buildHttpClientWithFakeUserSupport(this, var1, var2);
   }

   public Object calibrateOscillationPosition(int var1, Continuation var2) {
      return setActuator$default(this, "calibration", var1, (String)null, var2, 4, (Object)null);
   }

   public Object cancelWickDryMode(Continuation var1) {
      return setActuator$default(this, "wickdrys", false, (String)null, var1, 4, (Object)null);
   }

   public void clear() {
   }

   public Object configureOscillationFixed(boolean var1, int var2, int var3, Continuation var4) {
      String var5;
      if (var1) {
         var5 = "oscstateh";
      } else {
         var5 = "oscstatev";
      }

      ActuatorWrapper var6 = new ActuatorWrapper(var5, var2, (String)null, 4, (DefaultConstructorMarker)null);
      if (var1) {
         var5 = "oscfixh";
      } else {
         var5 = "oscfixv";
      }

      return this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{var6, new ActuatorWrapper(var5, var3, (String)null, 4, (DefaultConstructorMarker)null)}), var4);
   }

   public Object configureOscillationSwing(boolean var1, int var2, int var3, int var4, Continuation var5) {
      String var6;
      if (var1) {
         var6 = "oscstateh";
      } else {
         var6 = "oscstatev";
      }

      ActuatorWrapper var7 = new ActuatorWrapper(var6, var2, (String)null, 4, (DefaultConstructorMarker)null);
      if (var1) {
         var6 = "oscminh";
      } else {
         var6 = "oscminv";
      }

      ActuatorWrapper var8 = new ActuatorWrapper(var6, var3, (String)null, 4, (DefaultConstructorMarker)null);
      if (var1) {
         var6 = "oscmaxh";
      } else {
         var6 = "oscmaxv";
      }

      return this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{var7, var8, new ActuatorWrapper(var6, var4, (String)null, 4, (DefaultConstructorMarker)null)}), var5);
   }

   public Object createSchedule(DeviceSchedule var1, Continuation var2) {
      BlueDeviceSchedule var3 = var1.toBlueDeviceSchedule();
      return this.awaitCall(this.getDeviceRestApi().createSchedule(this.getAuthService().getUserIdForBlueCloud(), var3), var2);
   }

   public Object createUpdateWelcomeHome(WelcomeHomeLocation var1, Continuation var2) {
      return this.awaitCall(this.getDeviceRestApi().createUpdateWelcomeHome(this.getDeviceUuid(), WelcomeHomeLocation.Companion.toBlueWelcomeHomeLocation(var1)), var2);
   }

   public Object deleteSchedule(String var1, Continuation var2) {
      this.getDeviceRestApi().deleteSchedule(this.getAuthService().getUserIdForBlueCloud(), this.getDeviceUuid(), var1);
      return Unit.INSTANCE;
   }

   public Object deleteWelcomeHome(Continuation var1) {
      return this.awaitCall(this.getDeviceRestApi().deleteWelcomeHome(this.getDeviceUuid()), var1);
   }

   public Object doSuspendedApiCall(Function2 var1, Object var2, Continuation var3) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3);
   }

   public Object doSuspendedApiCall(Function3 var1, Object var2, Object var3, Continuation var4) {
      return BaseNetworkClient$_CC.$default$doSuspendedApiCall(this, var1, var2, var3, var4);
   }

   public AuthService getAuthService() {
      return this.authService;
   }

   public BlueCloudRestApi getDeviceRestApi() {
      Object var1 = this.getRetrofit().create(BlueCloudRestApi.class);
      Intrinsics.checkNotNullExpressionValue(var1, "create(...)");
      return (BlueCloudRestApi)var1;
   }

   public String getDeviceUuid() {
      return this.deviceUuid;
   }

   public Object getLatestSensorPoint(Continuation var1) {
      return ApiResult.Companion.fail((Throwable)(new NotImplementedError((String)null, 1, (DefaultConstructorMarker)null)));
   }

   public Interceptor getMockInterceptor() {
      return this.mockInterceptor;
   }

   public Object getMonthSensorPoints(long var1, Continuation var3) {
      label37: {
         if (var3 instanceof <undefinedtype>) {
            <undefinedtype> var10 = (<undefinedtype>)var3;
            if ((var10.label & Integer.MIN_VALUE) != 0) {
               var10.label += Integer.MIN_VALUE;
               var17 = var10;
               break label37;
            }
         }

         var17 = new ContinuationImpl(this, var3) {
            long J$0;
            long J$1;
            long J$2;
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getMonthSensorPoints(0L, (Continuation)this);
            }
         };
      }

      Object var21 = ((<undefinedtype>)var17).result;
      Object var11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var4 = ((<undefinedtype>)var17).label;
      Object var19;
      if (var4 != 0) {
         if (var4 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var1 = ((<undefinedtype>)var17).J$2;
         var1 = ((<undefinedtype>)var17).J$1;
         var1 = ((<undefinedtype>)var17).J$0;
         Map var25 = (Map)((<undefinedtype>)var17).L$1;
         List var18 = (List)((<undefinedtype>)var17).L$0;
         ResultKt.throwOnFailure(var21);
         var19 = var21;
      } else {
         ResultKt.throwOnFailure(var21);
         long var7 = System.currentTimeMillis() / 1000L;
         long var5 = var1 / 1000L;
         List var13 = BlueCloudSensor.Companion.getSensorNames();
         Map var22 = (Map)(new LinkedHashMap());
         var22.put("did", this.getDeviceUuid());
         var22.put("from", String.valueOf(var5));
         var22.put("to", String.valueOf(var7));
         Deferred var12 = this.getDeviceRestApi().getMonthDatapoints(this.getAuthService().getUserIdForBlueCloud(), var22, var13);
         ((<undefinedtype>)var17).L$0 = SpillingKt.nullOutSpilledVariable(var13);
         ((<undefinedtype>)var17).L$1 = SpillingKt.nullOutSpilledVariable(var22);
         ((<undefinedtype>)var17).J$0 = var1;
         ((<undefinedtype>)var17).J$1 = var7;
         ((<undefinedtype>)var17).J$2 = var5;
         ((<undefinedtype>)var17).label = 1;
         Object var23 = this.awaitCall(var12, (Continuation)var17);
         var19 = var23;
         if (var23 == var11) {
            return var11;
         }
      }

      ApiResult var26 = (ApiResult)var19;
      boolean var9 = var26.isFailure();
      var21 = null;
      if (var9) {
         return ApiResult.Companion.fromResult(var26, (Object)null);
      } else {
         List var27 = (List)var26.getOrNull();
         List var20 = (List)var21;
         if (var27 != null) {
            BlueDataWrapper var28 = (BlueDataWrapper)CollectionsKt.firstOrNull(var27);
            var20 = (List)var21;
            if (var28 != null) {
               var20 = var28.convertToSimpleIndoorDataPoints();
            }
         }

         return var20 == null ? new Failure((Throwable)(new IllegalArgumentException("The datapoints were not parsed correctly"))) : ApiResult.Companion.fromResult(var26, var20);
      }
   }

   public OkHttpClient getOkHttpClient() {
      return (OkHttpClient)this.okHttpClient$delegate.getValue();
   }

   public Object getRandomVerifyText(Continuation var1) {
      label25: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var9 = var3;
               break label25;
            }
         }

         var9 = new ContinuationImpl(this, var1) {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getRandomVerifyText((Continuation)this);
            }
         };
      }

      Object var4 = ((<undefinedtype>)var9).result;
      Object var6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var9).label;
      String var11;
      String var12;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         var12 = (String)((<undefinedtype>)var9).L$3;
         String var5 = (String)((<undefinedtype>)var9).L$2;
         byte[] var18 = (byte[])((<undefinedtype>)var9).L$1;
         SecureRandom var10 = (SecureRandom)((<undefinedtype>)var9).L$0;
         ResultKt.throwOnFailure(var4);
         var11 = var5;
      } else {
         ResultKt.throwOnFailure(var4);
         Timber.Forest.v("getting randomised verification for a provisioning device", new Object[0]);
         SecureRandom var7 = new SecureRandom();
         byte[] var15 = new byte[64];
         var7.nextBytes(var15);
         String var13 = Base64.encodeToString(var15, 0);
         var12 = (new RandomString(128, (SecureRandom)null, (String)null, 6, (DefaultConstructorMarker)null)).nextString();
         BlueCloudRestApi var8 = this.getDeviceRestApi();
         Intrinsics.checkNotNull(var13);
         Deferred var19 = var8.sendSecureVerification(new BlueCloudRestApi.VerificationWrapper(var13, var12));
         ((<undefinedtype>)var9).L$0 = SpillingKt.nullOutSpilledVariable(var7);
         ((<undefinedtype>)var9).L$1 = SpillingKt.nullOutSpilledVariable(var15);
         ((<undefinedtype>)var9).L$2 = var13;
         ((<undefinedtype>)var9).L$3 = var12;
         ((<undefinedtype>)var9).label = 1;
         Object var16 = this.awaitCall(var19, (Continuation)var9);
         if (var16 == var6) {
            return var6;
         }

         var11 = var13;
         var4 = var16;
      }

      ApiResult var14 = (ApiResult)var4;
      ApiResult.Companion var17 = ApiResult.Companion;
      Intrinsics.checkNotNull(var11);
      return var17.fromResult(var14, new RandomVerifyText(var11, var12));
   }

   public Resources getResources() {
      return this.resources;
   }

   public Retrofit getRetrofit() {
      return this.retroFitFactory(this.getAuthService().getBlueHomeHost());
   }

   public Object getSchedules(Continuation var1) {
      label37: {
         if (var1 instanceof <undefinedtype>) {
            <undefinedtype> var3 = (<undefinedtype>)var1;
            if ((var3.label & Integer.MIN_VALUE) != 0) {
               var3.label += Integer.MIN_VALUE;
               var6 = var3;
               break label37;
            }
         }

         var6 = new ContinuationImpl(this, var1) {
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.getSchedules((Continuation)this);
            }
         };
      }

      Object var11 = ((<undefinedtype>)var6).result;
      Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var2 = ((<undefinedtype>)var6).label;
      Object var7;
      if (var2 != 0) {
         if (var2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         ResultKt.throwOnFailure(var11);
         var7 = var11;
      } else {
         ResultKt.throwOnFailure(var11);
         Deferred var12 = this.getDeviceRestApi().getSchedule(this.getAuthService().getUserIdForBlueCloud(), this.getDeviceUuid());
         ((<undefinedtype>)var6).label = 1;
         Object var13 = this.awaitCall(var12, (Continuation)var6);
         var7 = var13;
         if (var13 == var4) {
            return var4;
         }
      }

      ApiResult var14 = (ApiResult)var7;
      List var8 = (List)var14.getOrNull();
      if (var8 != null) {
         Iterable var15 = (Iterable)var8;
         Collection var9 = (Collection)(new ArrayList(CollectionsKt.collectionSizeOrDefault(var15, 10)));

         for(BlueDeviceSchedule var16 : var15) {
            var9.add(DeviceSchedule.Companion.fromBlueDeviceSchedule(var16));
         }

         var8 = (List)var9;
      } else {
         var8 = null;
      }

      Timber.Forest var18 = Timber.Forest;
      StringBuilder var17 = new StringBuilder("getSchedules : schedules = ");
      var17.append(var8);
      var18.d(var17.toString(), new Object[0]);
      return ApiResult.Companion.fromResult(var14, var8);
   }

   public Object playAlarm(int var1, int var2, Continuation var3) {
      return this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("alarm", var1, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("alarmvol", var2, (String)null, 4, (DefaultConstructorMarker)null)}), var3);
   }

   public Object resetAutoModeDependency(Continuation var1) {
      return this.setAutoModeDependency("PM", var1);
   }

   public Retrofit retroFitFactory(String var1) {
      return BaseNetworkClient$_CC.$default$retroFitFactory(this, var1);
   }

   public Object setAirRefreshEnabled(boolean var1, Continuation var2) {
      return setActuator$default(this, "airrefresh", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setAirRefreshStatus(int var1, Continuation var2) {
      return setActuator$default(this, "arstate", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setAlarm(int var1, DeviceAlarm var2, Continuation var3) {
      StringBuilder var4 = new StringBuilder("alarm");
      var4.append(var1);
      String var5 = var4.toString();
      Object var6 = var2;
      if (var2 == null) {
         var6 = MapsKt.emptyMap();
      }

      return setActuator$default(this, var5, var6, (String)null, var3, 4, (Object)null);
   }

   public Object setApFanSpeed(int var1, Continuation var2) {
      return setActuator$default(this, "fsp0", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setApSubMode(int var1, boolean var2, String var3, Continuation var4) {
      return var2 ? this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("mainmode", MainMode.AirPurify.getValue(), var3), new ActuatorWrapper("apsubmode", var1, var3)}), var4) : this.setActuator("apsubmode", var1, var3, var4);
   }

   public void setAuthService(AuthService var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.authService = var1;
   }

   public Object setAutoMode(int var1, String var2, Continuation var3) {
      boolean var4 = true;
      if (var1 != 1) {
         var4 = false;
      }

      return this.setActuator("automode", var4, var2, var3);
   }

   public Object setAutoModeDependency(Object var1, Continuation var2) {
      Intrinsics.checkNotNull(var1, "null cannot be cast to non-null type kotlin.Pair<*, *>");
      Pair var5 = (Pair)var1;
      Timber.Forest var3 = Timber.Forest;
      StringBuilder var4 = new StringBuilder("setAutoModeDependency: nuPair = ");
      var4.append(var5);
      var3.d(var4.toString(), new Object[0]);
      Object var9 = var5.getFirst();
      Intrinsics.checkNotNull(var9, "null cannot be cast to non-null type kotlin.String");
      AutoModeTrigger var10 = new AutoModeTrigger((String)var9, (String)null, 2, (DefaultConstructorMarker)null);
      Object var6 = var5.getSecond();
      Intrinsics.checkNotNull(var6, "null cannot be cast to non-null type kotlin.String");
      ModeDependency var7 = new ModeDependency(var10, new G4NightModeTrigger((String)var6, (String)null, 2, (DefaultConstructorMarker)null));
      UpdateWrapper var8 = new UpdateWrapper(this.getDeviceUuid(), var7, (Object)null, 4, (DefaultConstructorMarker)null);
      return this.awaitCall(this.getDeviceRestApi().update(var8), var2);
   }

   public Object setAutoRh(int var1, Continuation var2) {
      return setActuator$default(this, "autorh", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setBrightness(int var1, Continuation var2) {
      return setActuator$default(this, "brightness", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setChildLock(int var1, Continuation var2) {
      boolean var3 = true;
      if (var1 != 1) {
         var3 = false;
      }

      return setActuator$default(this, "childlock", var3, (String)null, var2, 4, (Object)null);
   }

   public Object setCoolAutoLevel(int var1, Continuation var2) {
      return setActuator$default(this, "coolauto", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setCoolAutoPresets(int var1, double[] var2, Continuation var3) {
      return var2 != null && var2.length >= 3 ? this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("coolautotag", var1, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("coolautofs1", DeviceData.Companion.toServerValue(var2[0]), (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("coolautofs2", DeviceData.Companion.toServerValue(var2[1]), (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("coolautofs3", DeviceData.Companion.toServerValue(var2[2]), (String)null, 4, (DefaultConstructorMarker)null)}), var3) : setActuator$default(this, "coolautotag", var1, (String)null, var3, 4, (Object)null);
   }

   public Object setCoolEcoPresets(int var1, double[] var2, Continuation var3) {
      return var2 != null && var2.length >= 2 ? this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("coolecotag", var1, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("coolecofs1", DeviceData.Companion.toServerValue(var2[0]), (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("coolecofs2", DeviceData.Companion.toServerValue(var2[1]), (String)null, 4, (DefaultConstructorMarker)null)}), var3) : setActuator$default(this, "coolecotag", var1, (String)null, var3, 4, (Object)null);
   }

   public Object setCoolFanSpeed(int var1, Continuation var2) {
      return setActuator$default(this, "coolfs", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setCoolFanSpeedLevel(int var1, Continuation var2) {
      return setActuator$default(this, "coolfslevel", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setCoolSubMode(int var1, Continuation var2) {
      return setActuator$default(this, "coolsubmode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setDehSubMode(int var1, Continuation var2) {
      return setActuator$default(this, "dehsubmode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setDeviceName(String var1, Continuation var2) {
      Timber.Forest var4 = Timber.Forest;
      StringBuilder var3 = new StringBuilder("setDeviceName: nuValue = ");
      var3.append(var1);
      var4.d(var3.toString(), new Object[0]);
      NameConfiguration var5 = new NameConfiguration(var1);
      UpdateWrapper var6 = new UpdateWrapper(this.getDeviceUuid(), (Object)null, var5, 2, (DefaultConstructorMarker)null);
      return this.awaitCall(this.getDeviceRestApi().update(var6), var2);
   }

   public void setDeviceUuid(String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.deviceUuid = var1;
   }

   public Object setDisinfection(boolean var1, Continuation var2) {
      return setActuator$default(this, "disinfection", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setDualOscillationState(boolean var1, int var2, Continuation var3) {
      String var4;
      if (var1) {
         var4 = "oscstateh";
      } else {
         var4 = "oscstatev";
      }

      return setActuator$default(this, var4, var2, (String)null, var3, 4, (Object)null);
   }

   public Object setEcoMode(boolean var1, Continuation var2) {
      return setActuator$default(this, "eco", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setFanSpeed(int var1, Continuation var2) {
      return setActuator$default(this, "fanspeed", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setG4NightMode(int var1, String var2, Continuation var3) {
      boolean var4 = true;
      if (var1 != 1) {
         var4 = false;
      }

      return this.setActuator("nightmode", var4, var2, var3);
   }

   public Object setGermShieldMode(int var1, Continuation var2) {
      boolean var3 = true;
      if (var1 != 1) {
         var3 = false;
      }

      return setActuator$default(this, "germshield", var3, (String)null, var2, 4, (Object)null);
   }

   public Object setGermShieldNightMode(boolean var1, Continuation var2) {
      return setActuator$default(this, "gsnm", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHeatAutoTmp(double var1, Continuation var3) {
      return setActuator$default(this, "heattemp", DeviceData.Companion.toServerValue(var1), (String)null, var3, 4, (Object)null);
   }

   public Object setHeatEcoTmp(double var1, Continuation var3) {
      return setActuator$default(this, "ecoheattemp", DeviceData.Companion.toServerValue(var1), (String)null, var3, 4, (Object)null);
   }

   public Object setHeatFanSpeed(int var1, Continuation var2) {
      return setActuator$default(this, "heatfs", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHeatSubMode(int var1, Continuation var2) {
      return setActuator$default(this, "heatsubmode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHinsMode(boolean var1, Continuation var2) {
      return setActuator$default(this, "hins", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHinsNightMode(boolean var1, Continuation var2) {
      return setActuator$default(this, "nmhins", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHoverEnabled(boolean var1, Continuation var2) {
      return setActuator$default(this, "hover", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHumMode(boolean var1, Continuation var2) {
      return setActuator$default(this, "hummode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setHumSubMode(int var1, boolean var2, Continuation var3) {
      return var2 ? this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("wickdrys", false, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("humsubmode", var1, (String)null, 4, (DefaultConstructorMarker)null)}), var3) : setActuator$default(this, "humsubmode", var1, (String)null, var3, 4, (Object)null);
   }

   public Object setMainMode(int var1, String var2, Continuation var3) {
      return this.setActuator("mainmode", var1, var2, var3);
   }

   public Object setMode(int var1, String var2, Continuation var3) {
      return this.setActuator("mode", var1, var2, var3);
   }

   public Object setNightLampBrightness(int var1, Continuation var2) {
      return setActuator$default(this, "nlbrightness", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setNightLampSteplessBrightness(int var1, Continuation var2) {
      return setActuator$default(this, "nlstepless", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setOscillationMode(int var1, Continuation var2) {
      return setActuator$default(this, "oscmode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setOscillationParams(int var1, int var2, int var3, Continuation var4) {
      return this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("osc", var1, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("oscdir", var2, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("oscfs", var3, (String)null, 4, (DefaultConstructorMarker)null)}), var4);
   }

   public Object setOscillationState(int var1, Continuation var2) {
      return setActuator$default(this, "oscstate", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setPanelDisplayMode(int var1, Continuation var2) {
      return setActuator$default(this, "displaymode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setSensorMode(int var1, Continuation var2) {
      return setActuator$default(this, "sensormode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setSmartSubMode(int var1, Continuation var2) {
      return setActuator$default(this, "smartsubmode", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setStandBy(int var1, String var2, Continuation var3) {
      boolean var4 = true;
      if (var1 != 1) {
         var4 = false;
      }

      return this.setActuator("standby", var4, var2, var3);
   }

   public Object setTare(Continuation var1) {
      return setActuator$default(this, "nw", 1, (String)null, var1, 4, (Object)null);
   }

   public Object setTemperatureUnit(int var1, Continuation var2) {
      return setActuator$default(this, "tu", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setTimerDuration(int var1, Continuation var2) {
      return setActuator$default(this, "timdur", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setTimerDurationAndStatus(int var1, int var2, Continuation var3) {
      return this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("timdur", var1, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("timstate", var2, (String)null, 4, (DefaultConstructorMarker)null)}), var3);
   }

   public Object setTimerStatus(int var1, Continuation var2) {
      return setActuator$default(this, "timstate", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setUse24Hour(boolean var1, Continuation var2) {
      return setActuator$default(this, "hourformat", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setWickDryDurationAndOn(int var1, Continuation var2) {
      return this.setActuators(CollectionsKt.listOf(new ActuatorWrapper[]{new ActuatorWrapper("wickdrydur", var1, (String)null, 4, (DefaultConstructorMarker)null), new ActuatorWrapper("wickdrys", true, (String)null, 4, (DefaultConstructorMarker)null)}), var2);
   }

   public Object setWickDryEnabled(boolean var1, Continuation var2) {
      return setActuator$default(this, "wickdrye", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setWickDryOn(boolean var1, Continuation var2) {
      return setActuator$default(this, "wickdrys", var1, (String)null, var2, 4, (Object)null);
   }

   public Object setYwrmEnabled(boolean var1, Continuation var2) {
      UpdateWrapper var3 = new UpdateWrapper(this.getDeviceUuid(), (Object)null, MapsKt.mapOf(TuplesKt.to("ywrme", Boxing.boxBoolean(var1))), 2, (DefaultConstructorMarker)null);
      return this.awaitCall(this.getDeviceRestApi().update(var3), var2);
   }

   public Object stopAlarm(Continuation var1) {
      return setActuator$default(this, "alarmstop", 1, (String)null, var1, 4, (Object)null);
   }

   public Object updateSchedule(DeviceSchedule var1, Continuation var2) {
      label23: {
         if (var2 instanceof <undefinedtype>) {
            <undefinedtype> var4 = (<undefinedtype>)var2;
            if ((var4.label & Integer.MIN_VALUE) != 0) {
               var4.label += Integer.MIN_VALUE;
               var11 = var4;
               break label23;
            }
         }

         var11 = new ContinuationImpl(this, var2) {
            Object L$0;
            Object L$1;
            int label;
            Object result;
            final BlueCloudClient this$0;

            {
               this.this$0 = var1;
            }

            public final Object invokeSuspend(Object var1) {
               this.result = var1;
               this.label |= Integer.MIN_VALUE;
               return this.this$0.updateSchedule((DeviceSchedule)null, (Continuation)this);
            }
         };
      }

      Object var13 = ((<undefinedtype>)var11).result;
      Object var5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
      int var3 = ((<undefinedtype>)var11).label;
      Object var9;
      if (var3 != 0) {
         if (var3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
         }

         BlueDeviceSchedule var7 = (BlueDeviceSchedule)((<undefinedtype>)var11).L$1;
         DeviceSchedule var8 = (DeviceSchedule)((<undefinedtype>)var11).L$0;
         ResultKt.throwOnFailure(var13);
         var9 = var13;
      } else {
         ResultKt.throwOnFailure(var13);
         BlueDeviceSchedule var14 = var1.toBlueDeviceSchedule();
         Deferred var6 = this.getDeviceRestApi().updateSchedule(this.getAuthService().getUserIdForBlueCloud(), var14);
         ((<undefinedtype>)var11).L$0 = SpillingKt.nullOutSpilledVariable(var1);
         ((<undefinedtype>)var11).L$1 = SpillingKt.nullOutSpilledVariable(var14);
         ((<undefinedtype>)var11).label = 1;
         Object var12 = this.awaitCall(var6, (Continuation)var11);
         var9 = var12;
         if (var12 == var5) {
            return var5;
         }
      }

      ApiResult var10 = (ApiResult)var9;
      Intrinsics.checkNotNull(var10, "null cannot be cast to non-null type io.flatcircle.coroutinehelper.ApiResult<kotlin.Any?>");
      return var10;
   }

   @Metadata(
      d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¨\u0006\t"},
      d2 = {"Lcom/blueair/api/client/BlueCloudClient$Companion;", "", "<init>", "()V", "responseBodyToSimpleResponse", "Lio/flatcircle/coroutinehelper/ApiResult;", "Lcom/blueair/api/restapi/SimpleResponse;", "result", "Lokhttp3/ResponseBody;", "api_otherRelease"},
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

      public final ApiResult responseBodyToSimpleResponse(ApiResult var1) {
         Intrinsics.checkNotNullParameter(var1, "result");
         ApiResult.Companion var4 = ApiResult.Companion;
         ResponseBody var2 = (ResponseBody)var1.getOrNull();
         String var5;
         if (var2 != null) {
            String var3 = var2.string();
            var5 = var3;
            if (var3 != null) {
               return var4.fromResult(var1, new SimpleResponse((Integer)null, var5));
            }
         }

         Throwable var6 = var1.exceptionOrNull();
         if (var6 != null) {
            var5 = var6.getMessage();
         } else {
            var5 = null;
         }

         return var4.fromResult(var1, new SimpleResponse((Integer)null, var5));
      }
   }
}
