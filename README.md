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
    STATE_EXPANDED:  bottom sheet 处于完全展开的状态：当bottom sheet的高度低于CoordinatorLayout容器时，整个bottom sheet都可见；或者CoordinatorLayout容器已经被bottom sheet填满
    STATE_HIDDEN :完全隐藏BottomSheet

