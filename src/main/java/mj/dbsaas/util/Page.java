package mj.dbsaas.util;

import java.util.List;

public class Page<T> {
    private List<T> content;
    private int totalElements;
    private int currentPage;
    private int pageSize;
    private int totalPages;

    public Page(List<T> content, int totalElements, int currentPage, int pageSize) {
        this.content = content;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPages = (int) Math.ceil((double) totalElements / pageSize);
    }

    public boolean hasNext() {
        return currentPage < totalPages;
    }

    public boolean hasPrevious() {
        return currentPage > 1;
    }

    public List<T> getContent() { return content; }
    public int getTotalElements() { return totalElements; }
    public int getCurrentPage() { return currentPage; }
    public int getPageSize() { return pageSize; }
    public int getTotalPages() { return totalPages; }
}
