package ua.kiev.farmaco.inventory.utils;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ua.kiev.farmaco.inventory.model.Good;

/**
 * Author:  Serhii Synohub
 * Date:    01.05.2017
 */

public interface APEXRequestsHTTP {

    /**
     * 
     * @param barcode scanned barcode from a good or tasklist
     * @return
     */
    @GET("/{barcode}")
    Call<List<Good>> getGoodByBarcode(@Path("barcode") String barcode);

}
