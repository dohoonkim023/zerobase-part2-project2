package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemoRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional  //<-- 이게 활성화 되어 있으면 아무리 데이터 베이스에 넣었다 뺏다 해도 데이터베이스에 영향을 주지 않음.
public class JdbcMemoRepositoryTest {

    @Autowired
    JdbcMemoRepository jdbcMemoRepository;

    @Test
    void insertMemoTest() {
        //given (주어진 것)
        Memo newMemo = new Memo(2, "insertMemoTest");

        //when (주어진 것을 가지고 아래 내용을 했을 때, 여기선 save를 했을 때)
        jdbcMemoRepository.save(newMemo);

        //then (그러고 나면 이럴 것이다. 여기에 assert문이 보통 들어가게 된다.)
        Optional<Memo> result = jdbcMemoRepository.findByid(2);
        assertEquals(result.get().getText() , "insertMemoTest");
    }

    @Test
    void finalAllMemoTest() {
        //given
        List<Memo> memoList = jdbcMemoRepository.findAll();
        //when
        //then
        assertNotNull(memoList);
    }


}
