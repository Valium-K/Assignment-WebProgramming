package com.n2014758085.main.Service;

import com.n2014758085.main.domain.Basic;
import com.n2014758085.main.repository.BasicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {

    private final BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository) {
        this.basicRepository = basicRepository;
    }

    /*
    // // Pageable 적용 (출력 예제 Pageable 없는거 같아 주석처리함)
    public Page<Basic> findBasicList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());

        return basicRepository.findAll(pageable);
    }
    */

    // Pageable 미적용
    public List<Basic> findBasicList() {
        return basicRepository.findAll();
    }


    public Basic findBasicByIdx(Long idx) {
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public Basic saveBasic(Basic b) {
        Basic basic = basicRepository.save(b);
        return basic;
    }

    public void deleteBasic(Basic basic) {
        basicRepository.delete(basic);
    }
}
