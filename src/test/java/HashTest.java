import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import com.Interfaces.Filme_IF;
import com.Classes.Filme;
import com.Classes.Estruturas.TabelaHash;

public class HashTest {

    private TabelaHash TabelaHash;

    @Before
    public void init() {
        TabelaHash = new TabelaHash();
    }

    @Test
    public void testInsert() {
        Filme_IF filme1 = new Filme(1,"Alice no País das Maravilhas",5, 1999);
        Filme_IF filme2 = new Filme(10,"A Fantástica Fábrica de Chocolates",3, 2005);
        TabelaHash.insert(filme1);
        TabelaHash.insert(filme2);
    }

    @Test
    public void testRemove() throws Exception {
        Filme_IF filme1 = new Filme(1,"Alice no País das Maravilhas",5, 1999);
        Filme_IF filme2 = new Filme(10,"A Fantástica Fábrica de Chocolates",3, 2005);
        TabelaHash.insert(filme1);
        TabelaHash.insert(filme2);
        assertEquals(filme1, TabelaHash.remove(1));
    }

    @Test
    public void testSearch() throws Exception {
        Filme_IF filme1 = new Filme(1,"Alice no País das Maravilhas",5, 1999);
        Filme_IF filme2 = new Filme(10,"A Fantástica Fábrica de Chocolates",3, 2005);
        TabelaHash.insert(filme1);
        TabelaHash.insert(filme2);
        assertEquals(filme1, TabelaHash.search(1));
    }

    
}