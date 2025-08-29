package com.my.board.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
// 전체 페이지와 현재 페이지를 주면
// 페이징 블럭을 전달해 주는 서비스
public class PaginationService {
    private static final int BAR_LENGTH = 5;

    public List<Integer> getPaginationBarNumber(
            int currentPageNumber,
            int totalPageNumber
    ) {
        int startNumber =
                Math.max(currentPageNumber - (BAR_LENGTH / 2), 0);
        int endNumber =
                Math.min(startNumber + BAR_LENGTH, totalPageNumber);
        return IntStream.range(startNumber, endNumber)
                .boxed().toList();
        //  박싱을 해서 생성 되어지는 결과는 0 1 2 3 4
    }

    public int currentBarLength() {
        return BAR_LENGTH;
    }
}
