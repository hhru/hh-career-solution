package ru.hh.career.solution.dto;

import java.util.List;

public class PageResponseDto<T> {

  private List<T> items;

  private Long found;

  private Long pages;

  private Integer perPage;

  private Integer page;

  public PageResponseDto() {
  }

  public PageResponseDto(List<T> items, Long found, Integer perPage, Integer page) {
    this.items = items;
    this.found = found;
    this.pages = (found / perPage) + (found % perPage == 0 ? 0 : 1);
    this.perPage = perPage;
    this.page = page;
  }

  public List<T> getItems() {
    return items;
  }

  public void setItems(List<T> items) {
    this.items = items;
  }

  public Long getPages() {
    return pages;
  }

  public void setPages(Long pages) {
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
