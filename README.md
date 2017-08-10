# AutoFlowLayoutTest

## 一、AutoFlowLayout应用场景

流式布局，在很多标签类的场景中可以用的；而网格布局在分类中以及自拍九宫格等场景很常见。如下所示：

![](https://camo.githubusercontent.com/3f50a7cf83e34a94cf22cc3a47c58c93ab2dc135/687474703a2f2f75706c6f61642d696d616765732e6a69616e7368752e696f2f75706c6f61645f696d616765732f333938353536332d386337633534303166323630323731382e6a70673f696d6167654d6f6772322f6175746f2d6f7269656e742f7374726970253743696d61676556696577322f322f772f31323430)
如此使用频繁而又实现简单的控件，怎能不自己撸一个呢？控件，还是定制的好啊。

## 二、AutoFlowLayout实现效果

先介绍下自己撸的这个控件的功能及效果。

### 1.功能

### 流式布局

自动换行
行数自定：单行/多行
支持单选/多选
支持行居中/靠左显示
支持添加/删除子View
支持子View点击/长按事件
网格布局

行数/列数自定
支持单选/多选
支持添加/删除子View
支持子View点击/长按事件
支持添加多样式分割线及横竖间隔

### 2.效果

下面以gif图的形式展现下实现的效果，样式简单了些，不过依然能展示出这个简单控件的多功能实用性。

### 流式布局

![](https://camo.githubusercontent.com/b098afc31be9101862c32005de1b2a0964e4be50/687474703a2f2f75706c6f61642d696d616765732e6a69616e7368752e696f2f75706c6f61645f696d616765732f333938353536332d613064306431396464623737613964662e6769663f696d6167654d6f6772322f6175746f2d6f7269656e742f7374726970)

![](https://camo.githubusercontent.com/0fbed368575d6b25dd84175a2dd93102a73e4ddd/687474703a2f2f75706c6f61642d696d616765732e6a69616e7368752e696f2f75706c6f61645f696d616765732f333938353536332d653361653761653538343233633337332e6769663f696d6167654d6f6772322f6175746f2d6f7269656e742f7374726970)

### 网格布局

![](https://camo.githubusercontent.com/597e8b1ed16354fa84445987955d13188a2bd716/687474703a2f2f75706c6f61642d696d616765732e6a69616e7368752e696f2f75706c6f61645f696d616765732f333938353536332d333732336261386136623063313131342e6769663f696d6167654d6f6772322f6175746f2d6f7269656e742f7374726970)

最后一个是带间隔以及分割线的，由于录屏原因，只在跳过去的一瞬间显示了粉红色的一条线。真实如下图所示，可以定义横竖间距的大小，以及分割线的颜色，宽度。

![](https://camo.githubusercontent.com/2d428706adca762c9ddfaa8c18f545a2805126f7/687474703a2f2f75706c6f61642d696d616765732e6a69616e7368752e696f2f75706c6f61645f696d616765732f333938353536332d626131653834376634633033396633632e6a70673f696d6167654d6f6772322f6175746f2d6f7269656e742f7374726970253743696d61676556696577322f322f772f31323430)

## 三、AutoFlowLayout使用

### 1.添加依赖

①.在项目的 build.gradle 文件中添加

```ruby
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 
 ②.在 module 的 build.gradle 文件中添加依赖
 
 ```ruby
 dependencies {
	        compile 'com.github.LRH1993:AutoFlowLayout:1.0.5'
	}
 ```
 
 ### 2.属性说明

下表是自定义的属性说明，可在xml中声明，同时有对应的get/set方法，可在代码中动态添加。

![](https://camo.githubusercontent.com/ffd5ef67c6365b5567cb3167a4dbce4a73947b37/687474703a2f2f75706c6f61642d696d616765732e6a69616e7368752e696f2f75706c6f61645f696d616765732f333938353536332d396363323538666238333633616633392e706e673f696d6167654d6f6772322f6175746f2d6f7269656e742f7374726970253743696d61676556696577322f322f772f31323430)

### 3.使用示例

### 布局

```ruby
<?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
                    android:layout_width="match_parent"
                    android:layout_height="match_parent">
    <com.example.library.AutoFlowLayout
        android:id="@+id/afl_cotent"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
</RelativeLayout>
```
### 代码设置数据

```ruby
mFlowLayout.setAdapter(new FlowAdapter(Arrays.asList(mData)) {
            @Override
            public View getView(int position) {
                View item = mLayoutInflater.inflate(R.layout.special_item, null);
                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                tvAttrTag.setText(mData[position]);
                return item;
            }
        });
 
```
与ListView,GridView使用方式一样，实现FlowAdapter即可。





