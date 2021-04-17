package ru.hh.career.solution.dto;

import java.util.List;

public class PageResponseDto {

  List<Object> items;

  Integer pages;

  public PageResponseDto() {
  }

  public PageResponseDto(List<Object> items, Integer pages) {
    this.items = items;
    this.pages = pages;
  }

  public List<Object> getItems() {
    return items;
  }

  public void setItems(List<Object> items) {
    this.items = items;
  }

  public Integer getPages() {
    return pages;
  }

  public void setPages(Integer pages) {
    this.pages = pages;
  }
}
