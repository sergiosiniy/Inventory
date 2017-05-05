package ua.kiev.farmaco.inventory.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ua.kiev.farmaco.inventory.model.Goods;

/**
 * Author:  Serhii Synohub
 * Date:    01.05.2017
 *
 * Interface describes http request methods for communicating with DB Oracle through APEX
 */

public interface APEXRequestsHTTP {

    /**
     *
     * @param barcode scanned barcode from a good or tasklist
     * @return Goods object
     */
    @GET("/{barcode}")
    Call<List<Goods>> getGoodByBarcode(@Path("barcode") String barcode);

}
