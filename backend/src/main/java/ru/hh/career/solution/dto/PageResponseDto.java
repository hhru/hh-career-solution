package ru.hh.career.solution.dto;

import java.util.List;

public class PageResponseDto {

  List<Object> items;

  Long found;

  Integer pages;

  Integer perPage;

  Integer page;

  public PageResponseDto() {
  }

  public PageResponseDto(List<Object> items, Long found, Integer pages, Integer perPage, Integer page) {
    this.items = items;
    this.found = found;
    this.pages = pages;
    this.perPage = perPage;
    this.page = page;
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

  public Long getFound() {
    return found;
  }

  public void setFound(Long found) {
    this.found = found;
  }

  public Integer getPerPage() {
    return perPage;
  }

  public Integer getPage() {
    return page;
  }

  public void setPerPage(Integer perPage) {
    this.perPage = perPage;
  }

  public void setPage(Integer page) {
    this.page = page;
  }
}
