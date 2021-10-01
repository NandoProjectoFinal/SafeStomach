import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    private Main main;
    @BeforeEach
    public void escenario(){

    }

    @org.junit.jupiter.api.Test
    void arrLista() {
        System.out.println(main.arrLista(0)[1]);
        assertEquals("Bebida de almendras sabor chocolate 1 L", main.arrLista(0)[1]);
        System.out.println(main.arrLista(3)[1]);
        assertEquals("Papas Tika", main.arrLista(3)[1]);
        System.out.println(main.arrLista(6)[2]);
        assertEquals("Sow Pastas Chia Penne", main.arrLista(6)[2]);
    }


}