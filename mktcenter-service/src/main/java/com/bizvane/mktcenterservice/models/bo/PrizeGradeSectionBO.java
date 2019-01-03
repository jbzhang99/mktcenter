package com.bizvane.mktcenterservice.models.bo;

/**
 * Created by agan on 2018/12/24.
 */
public class PrizeGradeSectionBO {
    private int superCount;//特级区间
    private int classA;//一等奖区间
    private int secondLevel;//二等奖区间
    private int levelThree;//三等奖区间

    public int getSuperCount() {
        return superCount;
    }

    public void setSuperCount(int superCount) {
        this.superCount = superCount;
    }

    public int getClassA() {
        return classA;
    }

    public void setClassA(int classA) {
        this.classA = classA;
    }

    public int getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(int secondLevel) {
        this.secondLevel = secondLevel;
    }

    public int getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(int levelThree) {
        this.levelThree = levelThree;
    }
}
