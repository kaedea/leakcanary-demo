package me.kaede.leakcanarydemo.localvariable;

/**
 * Created by estel on 2015/10/28.
 */
class Docker {
	// 静态变量，将不会被回收，除非加载 Docker 类的 ClassLoader 被回收。
	static Box container;
}
