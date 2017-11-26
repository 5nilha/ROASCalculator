package com.fabioquint.roascalculator;

/**
 * Created by fabioquintanilha on 5/23/17.
 */

public class ROASMetric {

    int revenue;
    int adSpend;

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public int getRevenue() {
        return this.revenue;
    }

    public void setAdSpend(int adSpend) {
        this.adSpend = adSpend;
    }

    public double getAdSpend() {
        return this.adSpend;
    }

    public int calcMetric () {
        int result;
        result = this.revenue / this.adSpend;
        return result;
    }

    public String getRatio() {
        int commonFactor = commonFactors(this.revenue, this.adSpend);

        int ratioRevenue = revenue / commonFactor;
        int ratioadSpend = adSpend / commonFactor;

        return String.format(ratioRevenue + ":" + ratioadSpend);
    }

    public int commonFactors(int num1, int num2) {
        int temp;
        while (num2 != 0) {
            temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }
        return num1;
    }

    public String printData() {
        return String.format("The ratio indicates that for every dollar spent on shopping Campaigns, you get $%d in revenue.", calcMetric());
    }

}
