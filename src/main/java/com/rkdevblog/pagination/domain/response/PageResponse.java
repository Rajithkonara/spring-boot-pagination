package com.rkdevblog.pagination.domain.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.Getter;

@Getter
public class PageResponse {

  private final long totalItems;
  private final long totalPages;
  private final int page;
  private final int size;

  public PageResponse(Page<?> page) {
    this.totalItems = page.getTotalElements();
    this.totalPages = page.getTotalPages();
    Pageable pageable = page.getPageable();
    this.page = pageable.getPageNumber();
    this.size = pageable.getPageSize();
  }
}
