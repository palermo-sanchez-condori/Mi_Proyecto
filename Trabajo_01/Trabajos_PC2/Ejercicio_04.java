import java.util.*;

//me falta agregar concepto  y un ejemplo
/*
 * Busqueda externa Listas Invertidas son estructuras de datos que permiten
 * almacenar y buscar información de manera eficiente, especialmente en grandes
 * conjuntos de datos. Estas listas se utilizan comúnmente en motores de búsqueda,
 * bases de datos y sistemas de recuperación de información.
 * Una lista invertida asocia cada término o palabra clave con una lista de
 * documentos o registros donde aparece ese término. Esto permite realizar búsquedas
 * rápidas y eficientes, ya que en lugar de buscar en todos los documentos, se puede
 * ir directamente a la lista de documentos asociados con el término buscado.
 * 
 * funcionalidad:
 * 1. Indexación: Durante el proceso de indexación, se analiza el contenido de
 * los documentos y se crea una lista invertida que mapea cada término a los
 * documentos en los que aparece.
 * 2. Búsqueda: Cuando un usuario realiza una búsqueda, el sistema consulta la
 * lista invertida para encontrar rápidamente los documentos relevantes que
 * contienen los términos buscados.
 * 3. Eficiencia: Las listas invertidas son eficientes en términos de espacio y
 * tiempo, ya que permiten realizar búsquedas rápidas sin necesidad de escanear
 * todos los documentos.
 */
public class Ejercicio_04 {
    // Mapa que representa la lista invertida: término -> lista de documentos
    private Map<String, List<Integer>> listaInvertida = new HashMap<>();

    // Indexa un documento (simulado por un ID y su contenido)
    public void indexarDocumento(int idDocumento, String contenido) {
        String[] palabras = contenido.toLowerCase().split("\\W+");
        for (String palabra : palabras) {
            listaInvertida
                .computeIfAbsent(palabra, k -> new ArrayList<>())
                .add(idDocumento);
        }
    }

    // Busca documentos que contienen el término dado
    public List<Integer> buscar(String termino) {
        return listaInvertida.getOrDefault(termino.toLowerCase(), Collections.emptyList());
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        Ejercicio_04 buscador = new Ejercicio_04();

        // Indexar documentos
        buscador.indexarDocumento(1, "Java es un lenguaje de programación");
        buscador.indexarDocumento(2, "Listas invertidas permiten búsquedas rápidas");
        buscador.indexarDocumento(3, "La programación eficiente usa estructuras de datos");

        // Buscar documentos que contienen el término "programación"
        List<Integer> resultados = buscador.buscar("programación");
        System.out.println("Documentos que contienen 'programación': " + resultados);

        // Buscar documentos que contienen el término "listas"
        resultados = buscador.buscar("listas");
        System.out.println("Documentos que contienen 'listas': " + resultados);
    }
}

/* 
las busquedas en listas invertidas son eficientes porque permiten acceder directamente a los documentos relevantes sin necesidad de escanear todo el conjunto de datos. Al tener un índice que mapea términos a documentos, se reduce significativamente el tiempo de búsqueda, especialmente en grandes volúmenes de información. Esto es particularmente útil en aplicaciones como motores de búsqueda y bases de datos, donde la rapidez y eficiencia son cruciales para una buena experiencia del usuario.
se aplica en diferentes aplicaciones como motores de búsqueda (Google, Bing), sistemas de gestión de bases de datos (MySQL, PostgreSQL), sistemas de recuperación de información (bibliotecas digitales, archivos) y aplicaciones de análisis de texto (análisis de sentimientos, minería de datos).
unos ejemplos de listas invertidas son:
1. Motor de búsqueda web: Google utiliza listas invertidas para indexar páginas web y permitir búsquedas rápidas.
2. Sistemas de gestión de bases de datos: MySQL y PostgreSQL utilizan listas invertidas para optimizar consultas de texto completo.
3. Bibliotecas digitales: Sistemas como JSTOR o Google Books utilizan listas invertidas para facilitar la búsqueda de libros y artículos.

 */
