
> ### 栗子——自定义EditText实现右下角计数控件

---

![栗子配图.png](http://upload-images.jianshu.io/upload_images/2071764-8d148e73b77178de.png)

---

> ### 栗子惯例，先上GIF

|PERCENTAGE百分比效果|SINGULAR单数效果|
|:-------------:|:-------------:|
|![百分比类型.gif](http://upload-images.jianshu.io/upload_images/2071764-9050fc9e607002a4.gif)|![单数类型.gif](http://upload-images.jianshu.io/upload_images/2071764-085344ba61616d59.gif)|



> ### 使用姿势

#### 1.引用

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
dependencies {
	compile 'com.github.FJ917:FJEditTextCount:版本号'
	//compile 'com.github.FJ917:FJEditTextCount:v1.0.1'
}
```

#### 2.使用

##### 支持参数&方法汇总

|参数|说明|
|---|---|
|etText|xml参数，设置默认文字|
|etTextSize|xml参数，输入文字大小|
|etTextColor|xml参数，输入文字颜色|
|etPromptTextSize|xml参数，提示统计文字大小|
|etPromptTextColor|xml参数，提示统计文字颜色|
|etHintColor|xml参数，提示文字颜色|
|etHint|xml参数，设置提示文字|
|etMinHeight|xml参数，设置最小高度|
|etMaxLength|xml参数，设置最大长度（总字数）|
|etType|xml参数，设置提示统计显示类型(单数singular；百分percentage)|
|etLineColor|xml参数，设置横线颜色|
|getText()|java方法，获取输入的文字|
|setText|java方法，设置默认文字|
|show()|v1.0.3(含)版本后不需要设置|

---

##### v1.0.3版本

这个版本有较大的改动，一些以往在java中设置的参数，移到了xml中进行设置，但是保留了java中设置的方法，但是不建议使用！

**变动的参数**

|变动前(java中的方法)|变动后(xml参数)|参数说明|
|---------|---------|---------|
|setEtHint()|etHint|设置提示文字|
|setEtMinHeight()|etMinHeight|设置最小高度|
|setLength()|etMaxLength|设置最大长度（总字数）|
|setType()|etType|设置提示统计显示类型(单数singular；百分percentage)|
|setLineColor()|etLineColor|设置横线颜色|
|show()|无|属性移到xml不需要设置|
|getText()|保留|获取输入的文字|

**xml新增参数**

|参数|说明|
|---|---|
|etText|xml参数，设置默认文字|
|etTextSize|xml参数，输入文字大小|
|etTextColor|xml参数，输入文字颜色|
|etPromptTextSize|xml参数，提示统计文字大小|
|etPromptTextColor|xml参数，提示统计文字颜色|
|etHintColor|xml参数，提示文字颜色|
|setText|java方法，设置默认文字|


###### xml示例

```
<fj.edittextcount.lib.FJEditTextCount
        android:id="@+id/fjEdit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:etHint="请输入内容"
        app:etLineColor="@color/colorAccent"
        app:etMaxLength="66"
        app:etMinHeight="200dp"
        app:etPromptTextColor="@color/colorAccent"
        app:etPromptTextSize="18sp"
        app:etText="默认输入的文字"
        app:etTextColor="@color/colorAccent"
        app:etTextSize="20sp"
        app:etType="percentage" />
```

---

##### v1.0.2版本

使用方法和v1.0.1一致
新增获取输入内容的方法：` fjEdit.getText();`

---

##### v1.0.1版本

初次提交，实现基本功能~

###### xml

```
<fj.edittextcount.lib.FJEditTextCount
	android:id="@+id/fjEdit"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"/>
```

###### java

```
fjEdit = (FJEditTextCount) findViewById(R.id.fjEdit);
fjEdit.setEtHint("内容")//设置提示文字
	.setEtMinHeight(200)//设置最小高度，单位px
	.setLength(50)//设置总字数
	//TextView显示类型(SINGULAR单数类型)(PERCENTAGE百分比类型)
	.setType(FJEditTextCount.SINGULAR)
	.setLineColor("#3F51B5")//设置横线颜色
	.show();
```

---

> ### 实现原理

首先通过`LayoutInflater.from`获取到layout,然后`findViewById`拿到里面的控件，这里用了三个控件`EditText,TextView,View`,View是最下面的横线

```
LayoutInflater.from(context).inflate(R.layout.anfq_num_edittext, this, true);
etContent = (EditText) findViewById(R.id.etContent);
tvNum = (TextView) findViewById(R.id.tvNum);
vLine = findViewById(R.id.vLine);
```

然后提供一些设置值的方法，如右下角的类型（这里有两种类型，即：单数类型和百分比类型）、最大字符的长度、EditText的Hint、横线的颜色。

设置`EditText`的监听TextWatcher（这里是参考了网上的一些代码，具体链接找不到了）

```
public void afterTextChanged(Editable s) {
	editStart = etContent.getSelectionStart();
	editEnd = etContent.getSelectionEnd();
	// 先去掉监听器，否则会出现栈溢出
	etContent.removeTextChangedListener(mTextWatcher);
	// 注意这里只能每次都对整个EditText的内容求长度，不能对删除的单个字符求长度
	// 因为是中英文混合，单个字符而言，calculateLength函数都会返回1

	// 当输入字符个数超过限制的大小时，进行截断操作
	while (calculateLength(s.toString()) > MaxNum) { 
		s.delete(editStart - 1, editEnd);
		editStart--;
		editEnd--;
	}
	// 恢复监听器
	etContent.addTextChangedListener(mTextWatcher);
		setLeftCount();
	}

	/** 刷新剩余输入字数 */
	private void setLeftCount() {
		if(TYPES.equals(SINGULAR)){//类型1
			tvNum.setText(String.valueOf((MaxNum - getInputCount())));
		}else if(TYPES.equals(PERCENTAGE)){//类型2
			tvNum.setText(MaxNum-(MaxNum - getInputCount())+"/"+MaxNum);
		}
	}
	/** 获取用户输入内容字数 */
	private long getInputCount() {
		return calculateLength(etContent.getText().toString());
	}
	/**
	* 计算分享内容的字数，一个汉字=两个英文字母，一个中文标点=两个英文标点
	* 注意：该函数的不适用于对单个字符进行计算，因为单个字符四舍五入后都是1
	* @param cs
	* @return
	*/
	public static long calculateLength(CharSequence cs) {
		double len = 0;
		for (int i = 0; i < cs.length(); i++) {
			int tmp = (int) cs.charAt(i);
			if (tmp > 0 && tmp < 127) {
				len += 1;
			} else {
				len++;
			}
		}
		return Math.round(len);
	}
}
```

> ### 总结
> 这种EditText显示输入字数的控件在开发中经常用到，但是如果在多个地方用到的话都要做监听代码重复太多，所以做了一下封装，以便以后使用

---


> **个人博客：[WWW.FJ917.COM](http://www.fj917.com)**</br>
> **简书：[www.jianshu.com/u/3d2770e6e489](http://www.jianshu.com/u/3d2770e6e489)**</br>
> **CSDN：[blog.csdn.net/fj917](http://blog.csdn.net/fj917)**


|欢迎加入QQ交流群657206000[点我加入](http://shang.qq.com/wpa/qunwpa?idkey=9b454a6f01bd94d97e4c3f2771447a989ec77794eb5a563422263153c00f700d)|
|:---:|
|![QQ交流群：657206000](http://upload-images.jianshu.io/upload_images/2071764-bce605159bbceb2a.png)|