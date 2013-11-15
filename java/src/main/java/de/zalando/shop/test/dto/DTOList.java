package de.zalando.shop.test.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * A DTO to handle a list of arbitrary objects.
 *
 * @author  rnascimento
 */
public abstract class DTOList<T> {

    private int count;

    private List<T> data;

    public DTOList() {
        count = 0;
        data = new ArrayList<>();
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(final List<T> data) {
        this.data = data;
    }
}
