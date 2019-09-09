package spitter.utils;

import java.util.List;

public class DataTableInput {

    private int draw;
    private int length;
    private int start;

    private List<Column> columns;
    private List<Order> order;

    private Search search;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "DataTableInput{" +
                "draw=" + draw +
                ", length=" + length +
                ", start=" + start +
                ", columns=" + columns +
                ", order=" + order +
                ", search=" + search +
                '}';
    }
}
