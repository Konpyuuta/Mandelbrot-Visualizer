package org.example.mandelbrotview;

/**
 *
 * @author Maurice Amon
 */

public class PixelRange {

    private Integer startIndex;

    private Integer endIndex;

    public PixelRange(Integer startIndex, Integer endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }
}
