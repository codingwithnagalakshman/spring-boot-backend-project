package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Software {

    private String cycle;

    private String releaseDate;

    @Override
    public String toString() {
        return "Software{" +
                "cycle='" + cycle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", eol='" + eol + '\'' +
                ", latest='" + latest + '\'' +
                ", link='" + link + '\'' +
                ", lts='" + lts + '\'' +
                ", support='" + support + '\'' +
                ", discontinued='" + discontinued + '\'' +
                ", latestReleaseDate='" + latestReleaseDate + '\'' +
                '}';
    }

    private String eol;

    private String latest;

    private String link;

    private String lts;

    private String support;

    private String discontinued;

    private String latestReleaseDate;

    public String getLatestReleaseDate() {
        return latestReleaseDate;
    }

    public void setLatestReleaseDate(String latestReleaseDate) {
        this.latestReleaseDate = latestReleaseDate;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEol() {
        return eol;
    }

    public void setEol(String eol) {
        this.eol = eol;
    }

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLts() {
        return lts;
    }

    public void setLts(String lts) {
        this.lts = lts;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }
}
