package cn.flyexp.carclub.activity.iview;

/**
 * Created by Won on 2017/4/19.
 */

public interface IRegisterView {

    /**
     * showLoading 方法主要用于页面请求数据时显示加载状态
     */
    void showLoading();

    /**
     * showError 方法用于请求数据出错
     */
    void showError();

    /**
     * showComplete 方法用于请求数据完成
     */
    void showComplete();

}
