package com.example.QuranProject;

import java.sql.Date;

public class Report {
    Integer st_id;
    String st_name;
    String memorizeSurah;
    String memorizeRange;
    Float memorizeMark;
    String reviewSurah;
    String reviewRange;
    Float reviewMark;
    Date reportDate;
    Integer index;


    public Report(String memorizeSurah, String memorizeRange, Float memorizeMark, String reviewSurah, String reviewRange, Float reviewMark, Date reportDate) {
        this.memorizeSurah = memorizeSurah;
        this.memorizeRange = memorizeRange;
        this.memorizeMark = memorizeMark;
        this.reviewSurah = reviewSurah;
        this.reviewRange = reviewRange;
        this.reviewMark = reviewMark;
        this.reportDate = reportDate;
    }

    public Report(Integer st_id, String st_name, String memorizeSurah, String memorizeRange, Float memorizeMark, String reviewSurah, String reviewRange, Float reviewMark, Date reportDate, Integer index) {
        this.st_id = st_id;
        this.st_name = st_name;
        this.memorizeSurah = memorizeSurah;
        this.memorizeRange = memorizeRange;
        this.memorizeMark = memorizeMark;
        this.reviewSurah = reviewSurah;
        this.reviewRange = reviewRange;
        this.reviewMark = reviewMark;
        this.reportDate = reportDate;
        this.index = index;
    }

    public Integer getSt_id() {
        return st_id;
    }

    public String getMemorizeSurah() {
        return memorizeSurah;
    }

    public String getMemorizeRange() {
        return memorizeRange;
    }

    public Float getMemorizeMark() {
        return memorizeMark;
    }

    public String getReviewSurah() {
        return reviewSurah;
    }

    public String getReviewRange() {
        return reviewRange;
    }

    public Float getReviewMark() {
        return reviewMark;
    }

    public String getSt_name() {
        return st_name;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public Integer getIndex() {
        return index;
    }


}
