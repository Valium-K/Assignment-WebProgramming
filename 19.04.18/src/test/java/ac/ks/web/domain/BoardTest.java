package ac.ks.web.domain;

import ac.ks.web.repository.BoardRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board savedBoard;

    @Before
    public void init() {
        savedBoard = boardRepository.save(Board.builder()
                .title("제목1")
                .subTitle("부제목1")
                .content("내용1")
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build());
    }

    @Test
    public void testFindBoard() {
        List<Board> findByTitle = boardRepository.findAllByTitle("제목1");
        assertThat(findByTitle.size()).isEqualTo(1);

        List<Board> findByTitle2 = boardRepository.findAllByTitle("제목2");
        assertThat(findByTitle2.size()).isEqualTo(0);
    }

    @Test
    public void testUpdateBoard() {
        savedBoard.setTitle("수정1");
        boardRepository.save(savedBoard);

        Board findFirstByTitle = boardRepository
                .findFirstByTitle("수정1");
        assertThat(findFirstByTitle.getTitle()).isEqualTo("수정1");
    }

    @Test
    public void deleteBoard() {
        boardRepository.delete(savedBoard);
        List<Board> findAllBoard = boardRepository.findAll();
        assertThat(findAllBoard.size()).isEqualTo(0);
    }

}
