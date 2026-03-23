package com.blueair.viewcore.fragment;

import android.content.Context;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.viewcore.view.ProgressBlockerView;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J-\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/blueair/viewcore/fragment/ProgressFragment;", "", "getRootView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "progressBlockerView", "Lcom/blueair/viewcore/view/ProgressBlockerView;", "getProgressBlockerView", "()Lcom/blueair/viewcore/view/ProgressBlockerView;", "setProgressBlockerView", "(Lcom/blueair/viewcore/view/ProgressBlockerView;)V", "showProgress", "", "context", "Landroid/content/Context;", "shouldShow", "", "forcedColor", "", "(Landroid/content/Context;ZLjava/lang/Integer;)V", "hideProgress", "clearProgressFragment", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProgressFragment.kt */
public interface ProgressFragment {
    void clearProgressFragment();

    ProgressBlockerView getProgressBlockerView();

    ConstraintLayout getRootView();

    void hideProgress(Context context);

    void setProgressBlockerView(ProgressBlockerView progressBlockerView);

    void showProgress(Context context, boolean z, Integer num) throws NullPointerException;

    /* renamed from: com.blueair.viewcore.fragment.ProgressFragment$-CC  reason: invalid class name */
    /* compiled from: ProgressFragment.kt */
    public final /* synthetic */ class CC {
        public static /* synthetic */ void showProgress$default(ProgressFragment progressFragment, Context context, boolean z, Integer num, int i, Object obj) throws NullPointerException {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = true;
                }
                if ((i & 4) != 0) {
                    num = null;
                }
                progressFragment.showProgress(context, z, num);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showProgress");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            if (r10.findViewById(r0.getId()) == null) goto L_0x002e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void $default$showProgress(com.blueair.viewcore.fragment.ProgressFragment r7, android.content.Context r8, boolean r9, java.lang.Integer r10) throws java.lang.NullPointerException {
            /*
                androidx.constraintlayout.widget.ConstraintLayout r10 = r7.getRootView()
                if (r8 == 0) goto L_0x0011
                if (r10 == 0) goto L_0x0009
                goto L_0x0011
            L_0x0009:
                java.lang.NullPointerException r8 = new java.lang.NullPointerException
                java.lang.String r9 = "Your rootview can't be null, my guy"
                r8.<init>(r9)
                throw r8
            L_0x0011:
                if (r9 == 0) goto L_0x00cb
                if (r8 == 0) goto L_0x00cb
                if (r10 == 0) goto L_0x00cb
                com.blueair.viewcore.view.ProgressBlockerView r0 = r7.getProgressBlockerView()
                if (r0 == 0) goto L_0x002e
                com.blueair.viewcore.view.ProgressBlockerView r0 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                int r0 = r0.getId()
                android.view.View r0 = r10.findViewById(r0)
                if (r0 != 0) goto L_0x00cb
            L_0x002e:
                com.blueair.viewcore.view.ProgressBlockerView r1 = new com.blueair.viewcore.view.ProgressBlockerView
                r5 = 6
                r6 = 0
                r3 = 0
                r4 = 0
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.setProgressBlockerView(r1)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                int r0 = android.view.View.generateViewId()
                r8.setId(r0)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                r0 = 0
                r8.setShouldBlock(r0)
                androidx.constraintlayout.widget.ConstraintSet r1 = new androidx.constraintlayout.widget.ConstraintSet
                r1.<init>()
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                android.view.View r8 = (android.view.View) r8
                r10.addView(r8)
                r1.clone((androidx.constraintlayout.widget.ConstraintLayout) r10)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                int r2 = r8.getId()
                int r4 = r10.getId()
                r5 = 3
                r6 = 0
                r3 = 3
                r1.connect(r2, r3, r4, r5, r6)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                int r2 = r8.getId()
                int r4 = r10.getId()
                r5 = 4
                r3 = 4
                r1.connect(r2, r3, r4, r5, r6)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                int r2 = r8.getId()
                int r4 = r10.getId()
                r5 = 6
                r3 = 6
                r1.connect(r2, r3, r4, r5, r6)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                int r2 = r8.getId()
                int r4 = r10.getId()
                r5 = 7
                r3 = 7
                r1.connect(r2, r3, r4, r5, r6)
                r1.applyTo(r10)
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r10 = new androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
                r0 = -1
                r10.<init>((int) r0, (int) r0)
                android.view.ViewGroup$LayoutParams r10 = (android.view.ViewGroup.LayoutParams) r10
                r8.setLayoutParams(r10)
            L_0x00cb:
                com.blueair.viewcore.view.ProgressBlockerView r8 = r7.getProgressBlockerView()
                if (r8 == 0) goto L_0x00d6
                android.view.View r8 = (android.view.View) r8
                io.flatcircle.viewhelper.ViewExtensionsKt.show(r8, r9)
            L_0x00d6:
                if (r9 == 0) goto L_0x00e3
                io.flatcircle.viewhelper.ViewHelperUtil r8 = io.flatcircle.viewhelper.ViewHelperUtil.INSTANCE
                com.blueair.viewcore.view.ProgressBlockerView r9 = r7.getProgressBlockerView()
                android.view.View r9 = (android.view.View) r9
                r8.hideSoftKeyboard(r9)
            L_0x00e3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.fragment.ProgressFragment.CC.$default$showProgress(com.blueair.viewcore.fragment.ProgressFragment, android.content.Context, boolean, java.lang.Integer):void");
        }

        public static void $default$hideProgress(ProgressFragment _this, Context context) {
            showProgress$default(_this, context, false, (Integer) null, 4, (Object) null);
        }

        public static void $default$clearProgressFragment(ProgressFragment _this) {
            _this.setProgressBlockerView((ProgressBlockerView) null);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ProgressFragment.kt */
    public static final class DefaultImpls {
        @Deprecated
        public static void showProgress(ProgressFragment progressFragment, Context context, boolean z, Integer num) throws NullPointerException {
            CC.$default$showProgress(progressFragment, context, z, num);
        }

        @Deprecated
        public static void hideProgress(ProgressFragment progressFragment, Context context) {
            CC.$default$hideProgress(progressFragment, context);
        }

        @Deprecated
        public static void clearProgressFragment(ProgressFragment progressFragment) {
            CC.$default$clearProgressFragment(progressFragment);
        }
    }
}
