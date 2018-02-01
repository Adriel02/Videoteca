import java.util.Comparator;

/**
 * Created by Adriel on 30/06/2017.
 */
public class Film {
        private String title;   // nombre de la película
        private String genre;   // clasificación temática de la película
        private Integer year;       // año de estreno de la película

        /**
         * Constructor al que se le pasa el título,
         * el género y el año de estreno de la película
         *
         * @param title nombre de la película
         * @param genre género de la película
         * @param year año de estreno de la pelicula
         */

        public Film(String title, String genre, Integer year) {
            this.title = title;
            this.genre = genre;
            this.year = year;
        }

        /**
         * Devuelve el nombre de la película
         *
         * @return título de la película
         */
        public String getTitle() {
            return title;
        }

        /**
         * Devuelve la clasificación temática de la película
         *
         * @return género de la película
         */
        public String getGenre() {
            return genre;
        }

        /**
         * Devuelve el año de estreno de la película
         *
         * @return año de la película
         */
        public int getYear() {
            return year;
        }

        public String representacion(){
            return this.getTitle() +" | "+this.getGenre()+" | "+this.getYear();
        }

}
