import java.util.*;

/**
 * Created by Adriel on 30/06/2017.
 */


public class videoteca {
    public videoteca(String nombre){
        this.nombre=nombre;
    }

    public boolean add(Film pelicula){
        if(videotecaList.contains(pelicula)){
            return false;
        }
        videotecaList.add(pelicula);
        return true;
    }


    public void setOrder(int ord){
        this.orden=ord;
    }
    public int getOrden(){
        return orden;
    }

    public Set<Film>getFilms() {
        Set<Film> set = new TreeSet<>();
        if (orden == 1) {
            set = new TreeSet<>(new Comparator<Film>() {
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
        } else {
            set = new TreeSet<>(new Comparator<Film>() {
                @Override
                public int compare(Film o1, Film o2) {
                    if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
                        return o1.getGenre().compareTo(o2.getGenre());
                    }
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            });
        }
        for (Film e:videotecaList) {
            set.add(e);
        }
        return set;
    }


    public List<String>getGenres(){
        ArrayList<String> generos = new ArrayList<>();
        Map<String,Integer>mapa= new HashMap<>();
        for (Film e: videotecaList) {
            if (!mapa.containsKey(e.getGenre())){
                mapa.put(e.getGenre(),1 );
            }
            else {
                mapa.put(e.getGenre(), mapa.get(e.getGenre()) + 1);
            }
        }
        for (String key:mapa.keySet()) {
            generos.add(key+": "+mapa.get(key));
        }
        Collections.sort(generos, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return  o1.compareTo(o2);
            }
        });
        return generos;
    }

    public String toString(){
        Set<Film> set = getFilms();
        String stringNueva="";

            int cont=1;
            for (Film e: set) {
                stringNueva+= cont+") "+e.representacion()+"\n";
                cont++;
            }
        return this.nombre+":\n"+stringNueva;
    }

    private String nombre;
    private ArrayList<Film> videotecaList= new ArrayList<>();
    private int orden;
}
