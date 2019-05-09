package ac.ks.web.controller;

import ac.ks.web.domain.Board;
import ac.ks.web.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//joson으로 컨트롤러 작성
@Controller
public class BoardController {
    // GET /board -> 2000 OK Title 전체

    //생성자 주입 후 데이터 획득 이를 json으로 받아서 html로 출력한다.
    private BoardRepository boardRepository;
    // @Autowireld 붇으면 안됨 테스트코드면 되는데 실제 작성코드는 없애야함
    // @Autowired는 생성자 주입으로 바꿔야한다 꼭
    // 의존성 주입으로 가능한 것 나중에 찾아보기
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("")
    public String home() {
        return "home.html";
    }
    @GetMapping("/board")
    public List<String> getBoardTitleAll() {
        List<Board> boardList = boardRepository.findAll();

        List<String> stringList = new ArrayList<>();

        // for-loop

        //db에서 뭘 꺼내온다 = repository 접근한다 생각!
        for(Board b : boardList) {
            stringList.add(b.getTitle());
            stringList.add(b.getContent());
        }
        return stringList;


        /* 위의 포루프 대신 람다활용 코드 예제 - 같은값 출력되지는 않음 예제만 써둔거라서
        return boardList.stream()
                .map(i -> i.getContent())
                .collect(Collectors.toList());

         */
    }
}
