# MyBottomNavigation
BottomSheetBehavior,BottomNavigationView,DrawerLayout

### BottomSheetBehavior使用
    app:behavior_hideable="true" // 表示BottomSheet 完全隐藏，默认为false
    app:behavior_peekHeight="50dp" // 当为STATE_COLLAPSED（折叠）状态的时候bottom sheet残留的高度，默认为0
    app:layout_behavior="@string/bottom_sheet_behavior"
    BottomSheet 有以下5种状态
    STATE_COLLAPSED:磨人的折叠状态 显示高度可以通过app:behavior_peekHeight 设置
    STATE_DRAGGING:过渡状态，此时用户正在向上或者向下拖动bottom sheet
    STATE_SETTLING:视图从脱离手指自由滑动到最终停下的这一小段时间
    STATE_EXPANDED: bottom sheet 处于完全展开的状态：当bottom sheet的高度低于CoordinatorLayout容器时
                    整个bottom sheet都可见；或者CoordinatorLayout容器已经被bottom sheet填满
    STATE_HIDDEN :完全隐藏BottomSheet

### BottomNavigationView
    如下布局代码
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.design.widget.CoordinatorLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.item.nagigation.activity.OneActivity">

        <android.support.design.widget.AppBarLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <include layout="@layout/action_bar" />
        </android.support.design.widget.AppBarLayout>

        <FrameLayout
            android:id="@+id/lay_container"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginBottom="52dp"
            android:background="@color/colorAccent"
            app:layout_behavior="@string/appbar_scrolling_view_behavior" />

        <android.support.design.widget.FloatingActionButton
            android:id="@+id/btn_action"
            android:layout_width="52dp"
            android:layout_height="52dp"
            android:layout_gravity="end|bottom"
            android:layout_marginBottom="68dp"
            android:layout_marginEnd="16dp"
            android:padding="20dp"
            android:src="@drawable/ic_group"
            android:tint="@color/white"
            android:translationY="76dp"
            app:backgroundTint="@color/colorPrimary"
            app:elevation="4dp"
            app:pressedTranslationZ="10dp" />

        <android.support.design.widget.BottomNavigationView
            android:id="@+id/navigation"
            android:layout_width="match_parent"
            android:layout_height="52dp"
            android:layout_gravity="bottom"
            android:background="#ffffff"
            android:elevation="3dp"
            android:outlineProvider="bounds"
            android:translationZ="8dp"
            app:itemIconTint="@color/text_nav"
            app:itemTextColor="@color/text_nav"
            app:menu="@menu/navigation_items"
            tools:targetApi="lollipop"
            tools:visibility="visible" />
    </android.support.design.widget.CoordinatorLayout>

### 3.DrawerLayout 的简单使用
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.v4.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/drawer_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.item.nagigation.activity.ThreeActivity"
        tools:openDrawer="start">

        <include
            layout="@layout/layout_main"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />

        <FrameLayout
            android:id="@+id/nav_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_gravity="start"
            android:background="@drawable/ic_home_weibo" />
    </android.support.v4.widget.DrawerLayout>

    public class ThreeActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_three);
            Toolbar toolbar = (Toolbar) findViewById(R.id.main_bar);
            setSupportActionBar(toolbar);
            DrawerLayout mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, mDrawer, toolbar, R.string.navigation_drawer_open,
                    R.string.navigation_drawer_close
            );
            mDrawer.setDrawerListener(toggle);
            toggle.syncState();
        }

        @Override
        public void onBackPressed() {
            DrawerLayout mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (mDrawer.isDrawerOpen(GravityCompat.START)) {
                mDrawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }
    }
### Glide 为图片添加蒙板和着色的效果
    Glide.with(this)
            .load(R.drawable.bg_src_tianjin)
            .into(new SimpleTarget<Drawable>() {
                @Override
                public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                    // 拿到Glide的Drawable
                    Drawable drawable = resource.getCurrent();
                    // 使用适配类进行包装
                    drawable = DrawableCompat.wrap(drawable);
                    // 设置着色的效果和颜色，蒙板模式
                    drawable.setColorFilter(getResources().getColor(R.color.test_two),
                            PorterDuff.Mode.SCREEN);
                    // 设置给ImageView
                    img_bg.setImageDrawable(drawable);
                }
            });
    <ImageView
        android:id="@+id/img_bg"
        android:layout_width="match_parent"
        android:contentDescription="@string/app_name"
        android:scaleType="centerCrop"
        android:foreground="#30000000"
        android:layout_height="0dp"
        android:layout_weight="1"/>
    <!--android:foreground="#30000000" 遮罩颜色-->

### 5.为APP启动页 跟换背景的颜色
    使用属性动画来实现，设置开始和结束的颜色
    /**
     * 给背景设置一个动画
     * @param endProgress 动画的结束进度
     * @param endCallback 动画结束时触发
     */
    private void startAnim(float endProgress, final Runnable endCallback) {
        // 获取一个最终的颜色
        int finalColor = getResources().getColor(R.color.white);
        ArgbEvaluator evaluator = new ArgbEvaluator();
        int endColor = (int) evaluator.evaluate(endProgress, mBgDrawable.getColor(), finalColor);
        // 构建一个属性动画
        ValueAnimator valueAnimator = ObjectAnimator.ofObject(this, property, evaluator, endColor);
        valueAnimator.setDuration(1500);
        valueAnimator.setIntValues(mBgDrawable.getColor(), endColor); // 开始结束值
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // 结束时触发
                endCallback.run();
            }
        });
        valueAnimator.start();
    }

