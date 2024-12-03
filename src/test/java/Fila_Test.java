import static org.junit.Assert.*;
import org.junit.Test;

import com.Interfaces.Filme_IF;
import com.Classes.Estruturas.Fila;
import com.Classes.Filme;

public class Fila_Test {
    private Fila fila = new Fila();
    
    @Test
    public void testEnqueue() {
        Filme_IF filme = new Filme(1, "A volta dos que não foram", 4, 1999);
        fila.enqueue(filme);
        
        assertFalse(fila.isEmpty());
    }
    
    @Test
    public void testDequeue() throws Exception {
        Filme_IF filme1 = new Filme(1, "A volta dos que não foram", 4, 1999);
        Filme_IF filme2 = new Filme(2,"Vini perdeu a bola de ouro :(",1, 2024);

        fila.enqueue(filme1);
        fila.enqueue(filme2);

        Filme_IF dequeuedFilme = fila.dequeue();

        assertEquals(filme1, dequeuedFilme);
        assertFalse(fila.isEmpty());
    }
    
    @Test(expected = Exception.class)
    public void testDequeueEmptyFila() throws Exception {
        fila.dequeue();
    }
    
    @Test
    public void testImprimir() throws Exception {
        Filme_IF filme1 = new Filme(1, "A volta dos que não foram", 4, 1999);
        Filme_IF filme2 = new Filme(2,"Clube da luta", 5,1999);
        fila.enqueue(filme1);
        fila.enqueue(filme2);
        
        fila.imprimirOrdenado();
        
        assertFalse(fila.isEmpty());
    }
}