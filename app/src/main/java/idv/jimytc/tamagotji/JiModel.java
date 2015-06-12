package idv.jimytc.tamagotji;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jimytc on 6/12/15.
 */
public class JiModel {
    @SerializedName("id")
    public String mId;
    @SerializedName("status")
    public int mStatus;

    @Override
    public String toString() {
        return "ji id: " + mId + ", status: " + mStatus;
    }
}
