package idv.jimytc.tamagotji;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by jimytc on 6/12/15.
 */
public interface JiService {
    @GET("/chirpies")
    List<JiModel> getJiList();

    @POST("/chirpies")
    JiModel createJi();

    @GET("/chirpies/{id}")
    JiModel getJiStatus(@Path("id") String id);

    @POST("/chirpies/{id}/walk")
    JiModel doWalk(@Path("id") String id, @Query("steps") int steps);
}
