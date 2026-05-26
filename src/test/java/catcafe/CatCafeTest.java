package catcafe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CatCafeTest {
    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenReturnZero() {
        // given
        CatCafe cafe = new CatCafe();

        // when
        long catCount = cafe.getCatCount();

        // then
        assertEquals(0, catCount);
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenReturnOne() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Garfield", 8);
        cafe.addCat(cat);

        // when
        long catCount = cafe.getCatCount();

        // then
        assertEquals(1, catCount);
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenReturnThree() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat1 = new FelineOverLord("Garfield", 8);
        FelineOverLord cat2 = new FelineOverLord("Ostin", 5);
        FelineOverLord cat3 = new FelineOverLord("Stiew", 12);
        cafe.addCat(cat1);
        cafe.addCat(cat2);
        cafe.addCat(cat3);

        // when
        long catCount = cafe.getCatCount();

        // then
        assertEquals(3, catCount);
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenReturnNull() {
        // given
        CatCafe cafe = new CatCafe();

        // when + then
        assertThrows(NullPointerException.class, () -> cafe.addCat(null));
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenSearchCat() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Garfield", 8);
        cafe.addCat(cat);

        // when
        FelineOverLord ourcat = cafe.getCatByName("Garfield");

        // then
        assertSame(ourcat, cat);
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenSearchAnotherCat() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Garfield", 8);
        cafe.addCat(cat);

        // when
        FelineOverLord ourcat = cafe.getCatByName("Kail");

        // then
        assertNull(ourcat);
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenSearchNull() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Garfield", 8);
        cafe.addCat(cat);

        // when
        FelineOverLord ourcat = cafe.getCatByName(null);

        // then
        assertNull(ourcat);
    }

    @Test
    void getCatCount_givenEmptyCafe_whenCountingCats_thenReturnMinWeight() {
        // given
        CatCafe cafe = new CatCafe();
        FelineOverLord cat = new FelineOverLord("Garfield", 1);
        cafe.addCat(cat);

        // when
        FelineOverLord ourcat = cafe.getCatByWeight(1, 5);

        // then
        assertSame(cat, ourcat);
    }
}
