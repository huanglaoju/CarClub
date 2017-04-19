package cn.flyexp.carclub.activity.iview;

import java.util.ArrayList;

import cn.flyexp.carclub.base.IBaseView;

/**
 * Created by Won on 2017/4/19.
 */

public interface IMainView extends IBaseView {

    /**
     * loadingComplete 方法用于请求数据完成
     */
    void showComplete(ArrayList<?> models);

}
