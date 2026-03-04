package ch01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

class GoldTest {

    @Test
    void testPredicate() {
        // Gold試験に出そうな、型推論を伴うラムダ式
        Predicate<String> p = s -> s.length() > 5;
        
        // 期待する結果をチェック（"JavaGold"は5文字より多いので true）
        assertTrue(p.test("JavaGold")); 
        
        // もし false を期待して書いたのに結果が true だった場合、エラーで教えてくれる
        assertFalse(p.test("Java"));
    }
}