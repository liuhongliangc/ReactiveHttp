package leavesc.hello.network.http.datasource;

import android.util.Log;

import leavesc.hello.network.http.basis.BaseRemoteDataSource;
import leavesc.hello.network.http.basis.callback.RequestCallback;
import leavesc.hello.network.http.datasource.base.IWeatherDataSource;
import leavesc.hello.network.http.service.ApiService;
import leavesc.hello.network.model.Weather;
import leavesc.hello.network.viewmodel.base.BaseViewModel;

/**
 * 作者：leavesC
 * 时间：2018/10/27 20:48
 * 描述：用来实现接口的实际调用，只负责请求数据并传递请求结果
 * GitHub：https://github.com/leavesC
 */
public class WeatherDataSource extends BaseRemoteDataSource implements IWeatherDataSource {

    public WeatherDataSource(BaseViewModel baseViewModel) {
        super(baseViewModel);
    }

    @Override
    public void queryWeather(String cityName, RequestCallback<Weather> responseCallback) {
        Log.e("aaaaa", "queryWeather: ");
        execute(getService(ApiService.class).queryWeather(cityName), responseCallback);
    }

}
