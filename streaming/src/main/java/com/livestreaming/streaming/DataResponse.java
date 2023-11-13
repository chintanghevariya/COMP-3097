package com.livestreaming.streaming;

import java.util.List;

public class DataResponse {

    private String status;
    private int totalResults;
    private List<articles> articles;

    public DataResponse() {
    }

    public DataResponse(String status, int totalResults, List<articles> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int number) {
        this.totalResults = number;
    }

    public List<articles> getArticles() {
        return articles;
    }

    public void setArticlesList(List<articles> articles) {
        this.articles = articles;
    }
}
