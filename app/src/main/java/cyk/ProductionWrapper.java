package cyk;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



public class ProductionWrapper {
    @Expose
    @SerializedName("left")
    private String leftSide;
    @Expose
    @SerializedName("right")
    private String rightSide;

    public ProductionWrapper(String leftSide, String rightSide) {
        this.leftSide = leftSide;
        this.rightSide = rightSide;
    }

    public String getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(String leftSide) {
        this.leftSide = leftSide;
    }

    public String getRightSide() {
        return rightSide;
    }

    public void setRightSide(String rightSide) {
        this.rightSide = rightSide;
    }
}
