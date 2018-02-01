import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

/**
 * Created by Adriel on 30/06/2017.
 */
public class videotecaTest {
    videoteca miVideoteca= new videoteca("Mi videoteca");
    Film miserables;
    Film fantasmaOpera;
    Film cantandoBajoLLuevia;
    Film forrestGump;

    videoteca videotecaOrdenada0= new videoteca("Videoteca Ordenada con SET=0");
    videoteca videotecaOrdenada1= new videoteca("Videoteca Ordenada con SET=1");
    String mivideotecaString0="";
    String mivideotecaString1="";
    ArrayList<String> stringLista = new ArrayList<>();

    Set<Film> cancionesSet1 = new TreeSet<>(new Comparator<Film>() {
        @Override
        public int compare(Film o1, Film o2) {
            if(o1.getYear()>o2.getYear()){
                return 1;
            }
            if(o1.getYear()<o2.getYear()){
                return -1;
            }
            if(o1.getYear()==o2.getYear()){
                return o1.getTitle().compareTo(o2.getTitle());
            }
            return 0;
        }
    });

    Set<Film> cancionesSet0 = new TreeSet<>(new Comparator<Film>() {
        @Override
        public int compare(Film o1, Film o2) {
            if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
                return o1.getGenre().compareTo(o2.getGenre());
            }
            return o1.getTitle().compareTo(o2.getTitle());
        }
    });




    @Before
    public void inicializador(){
         miserables=new Film("Los miserables", "Musical", 2012);
         fantasmaOpera=new Film("El fantasma de la ópera", "Musical", 2004);
         cantandoBajoLLuevia=new Film("Cantando bajo la lluvia", "Musical", 1952);
         forrestGump=new Film("Forrest Gump", "Comedia", 1994);

        miVideoteca.add(miserables);
        miVideoteca.add(fantasmaOpera);
        //miVideoteca.add(cantandoBajoLLuevia);
        //miVideoteca.add(forrestGump);

        //videotecaOrdenada0.setOrder(0);
        miVideoteca.getFilms();
        mivideotecaString0="Mi videoteca:\n1) Cantando bajo la lluvia | Musical | 1952\n2) El fantasma de la ópera | Musical | 2004\n3) Forrest Gump | Comedia | 1994\n4) Los miserables | Musical | 2012\n";
        mivideotecaString1="Mi videoteca:\n1) Cantando bajo la lluvia | Musical | 1952\n2) Forrest Gump | Comedia | 1994\n3) El fantasma de la ópera | Musical | 2004\n4) Los miserables | Musical | 2012\n";

        cancionesSet0.add(miserables);
        cancionesSet0.add(fantasmaOpera);
        cancionesSet0.add(cantandoBajoLLuevia);
        cancionesSet0.add(forrestGump);

        cancionesSet1.add(miserables);
        cancionesSet1.add(fantasmaOpera);
        cancionesSet1.add(cantandoBajoLLuevia);
        cancionesSet1.add(forrestGump);

        stringLista.add("Comedia: 1");
        stringLista.add("Musical: 3");



        Collections.sort(stringLista, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }


    //Escriba aquí los tests
    @Test
    public void pruebaConstructor(){
        assertEquals("Los miserables | Musical | 2012",new Film("Los miserables","Musical",2012).representacion());
        assertEquals("El fantasma de la ópera | Musical | 2004",new Film("El fantasma de la ópera","Musical",2004).representacion());
        assertEquals("Cantando bajo la lluvia | Musical | 1952",new Film("Cantando bajo la lluvia", "Musical", 1952).representacion());
        assertEquals("Forrest Gump | Comedia | 1994",new Film("Forrest Gump", "Comedia", 1994).representacion());
        assertEquals("Mi videoteca:\n",new videoteca("Mi videoteca").toString());
    }

    @Test
    public void pruebaAdd(){
        assertFalse("Se ha añadido correctamente",miVideoteca.add(miserables));
        assertFalse("Se ha añadido correctamente",miVideoteca.add(fantasmaOpera));
        assertTrue("Se ha añadido correctamente",miVideoteca.add(cantandoBajoLLuevia));
        assertTrue("Se ha añadido correctamente",miVideoteca.add(forrestGump));
    }

    @Test
    public void pruebaSetOrder(){
        miVideoteca.setOrder(0);
        assertEquals(miVideoteca.getOrden(),0);
        miVideoteca.setOrder(1);
        assertEquals(miVideoteca.getOrden(),1);

    }

    @Test
    public void pruebaToString(){
        miVideoteca.setOrder(0);
        assertEquals(miVideoteca.toString(),mivideotecaString0);
        miVideoteca.setOrder(1);
        assertEquals(miVideoteca.toString(),mivideotecaString1);
    }

    @Test
    public void pruebaGetFilms(){
        miVideoteca.setOrder(0);
        assertEquals(miVideoteca.getFilms(),cancionesSet0);
        miVideoteca.setOrder(1);
        assertEquals(miVideoteca.getFilms(),cancionesSet1);
    }

    @Test
    public void pruebaGetGenres(){
        assertEquals(miVideoteca.getGenres(),stringLista);
    }
}