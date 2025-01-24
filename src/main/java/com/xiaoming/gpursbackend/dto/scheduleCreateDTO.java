package com.xiaoming.gpursbackend.dto;

import java.time.LocalDateTime;

public class scheduleCreateDTO {
    private String title;
    private LocalDateTime start;
    private LocalDateTime end;
    private int gpunum;
    private String name;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getgpunum() {
        return gpunum;
    }

    public void setgpunum(int gpunum) {
        this.gpunum = gpunum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
